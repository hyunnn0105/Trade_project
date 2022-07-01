package com.jdbc.trade.tradepost.repository;

import com.jdbc.trade.Connect;
import com.jdbc.trade.tradepost.domain.Trade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class TradeOracleRepo implements TradeRepository{

    @Override
    public boolean inputinformation(Trade trade) {

        String sql = "INSERT INTO trade VALUES (?,?,?,?,?,?,?,?)";

        try (Connection conn = Connect.makeConnection()){

            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,trade.getTraNu());
            pstmt.setString(2,trade.getTraNm());
            pstmt.setString(3,trade.getItem());
            pstmt.setInt(4,trade.getPrice());
            pstmt.setString(5,trade.getTraPhone());
            pstmt.setString(6,trade.getPostMethod());
            pstmt.setString(7,trade.getPostAddr());
            pstmt.setString(8,trade.getPostNum());

            int result = pstmt.executeUpdate();

            if (result != 0){
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Map<Integer, Trade> findAll() {

        Map<Integer,Trade> tradeMap = new HashMap<>();

        String sql = "SELECT * FROM trade ORDER BY tra_nu";

        try(Connection conn = Connect.makeConnection()){

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Trade t = new Trade(
                      rs.getInt("tra_nu")
                        , rs.getString("tra_nm")
                        , rs.getString("item")
                        ,rs.getInt("price")
                        ,rs.getString("tra_phone")
                        ,rs.getString("post_method")
                        ,rs.getString("post_addr")
                        ,rs.getString("post_num")
                );
                tradeMap.put(t.getTraNu(), t);
            }
            return tradeMap;

        } catch (Exception e){
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    @Override
    public Trade findSomeone(int traNu) {
        String sql = "SELECT * FROM trade WHERE tra_nu = ? ";


        try(Connection conn = Connect.makeConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,traNu);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                Trade t = new Trade(
                        rs.getInt("tra_nu")
                        , rs.getString("tra_nm")
                        , rs.getString("item")
                        , rs.getInt("price")
                        , rs.getString("tra_phone")
                        , rs.getString("post_method")
                        , rs.getString("post_addr")
                        , rs.getString("post_num")
                );
                return t;
            }
            return null;


        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updatePostNum(String postnum, int tranu) {

        // 번호로 찾아서 업데이트,,,
        String sql = "UPDATE trade " +
                "SET post_num = ? " +
                "WHERE tra_nu = ? ";

        try (Connection conn = Connect.makeConnection()){

            PreparedStatement pstmt = conn.prepareStatement(sql);

            //if (tranu == findSomeone(tranu).getTraNu()){
                // traNum으로 postNum 넣어야할 위치 찾기

                pstmt.setString(1,postnum);
                pstmt.setInt(2,tranu);

                int result = pstmt.executeUpdate();

                conn.commit();
                return true;

//            }else {
//                return false;
//            }


        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(int traNu) {

        String sql = "DELETE FROM trade WHERE tra_nu = ? ";

        try(Connection conn = Connect.makeConnection()) {
            // 오토커밋 방지
            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(sql);

            // ? 채워넣기?
            pstmt.setInt(1, traNu);

            int result = pstmt.executeUpdate();

            if (result != 0){
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }



        } catch (Exception e){

        }
        return false;
    }
}
