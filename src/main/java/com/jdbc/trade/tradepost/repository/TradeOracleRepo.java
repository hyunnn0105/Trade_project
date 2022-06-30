package com.jdbc.trade.tradepost.repository;

import com.jdbc.trade.Connect;
import com.jdbc.trade.tradepost.domain.Trade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class TradeOracleRepo implements TradeRepository{

    @Override
    public boolean inputinformation(Trade trade) {
        String sql = "INSERT INTO trade VALUES(?,?,?,?,?,?,?,?)";

        try (Connection conn = Connect.makeConnection()){

            conn.setAutoCommit(false);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,1);
            pstmt.setString(2,trade.getTraNm());
            pstmt.setString(3,trade.getItem());
            pstmt.setInt(4,trade.getPrice());
            pstmt.setString(5,trade.getPostMethod());
            pstmt.setString(6,trade.getTraPhone());
            pstmt.setString(7,trade.getPostAddr());
            pstmt.setInt(8,trade.getPostNum());

            int result = pstmt.executeUpdate();

            if (result!=0){
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public Map<Integer, String> findAll() {
        return null;
    }

    @Override
    public boolean findSomeone(int traNu) {
        return false;
    }

    @Override
    public boolean updatePostNum(int postNum) {
        return false;
    }

    @Override
    public boolean delete(int traNu) {
        return false;
    }
}
