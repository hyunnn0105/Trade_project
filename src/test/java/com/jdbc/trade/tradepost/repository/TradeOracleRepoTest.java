package com.jdbc.trade.tradepost.repository;

import com.jdbc.trade.tradepost.domain.Trade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TradeOracleRepoTest {

    TradeRepository repository = new TradeOracleRepo();

    @Test
    @DisplayName("값이 들어가야한다")
    void inputTest(){
        Trade ko = new Trade();
        ko.setTraNu(5);
        ko.setTraNm("라라라");
        ko.setItem("장난감");
        ko.setPostMethod("택배");
        ko.setPrice(13000);
        ko.setTraPhone("01011112222");
        ko.setPostAddr("경기도 의왕시 00동 00길 00아파트 000동 000호");
        ko.setPostNum("");

        boolean inputtest = repository.inputinformation(ko);
        assertFalse(!inputtest);
    }

    @Test
    @DisplayName("값이 삭제되어야한다")
    void removeTest(){
        int traNu = 5;
        boolean remove = repository.delete(traNu);
        Trade trade  = repository.findSomeone(traNu);
        assertTrue(remove);

    }



    @Test
    @DisplayName("한 사람을 찾을 수 있어야한다")
    void findsomeOne(){

        Trade t = repository.findSomeone(4);
        assertEquals("가가가", t.getTraNm());
    }


    @Test
    @DisplayName("찾은 사람의 정보를 업데이트 할 수 있어야한다")
    void updateTest(){

        int tranum = 3;
        String postnum = "987987987987";

        boolean result = repository.updatePostNum(postnum, tranum);

        assertTrue(result);


    }

    @Test
    @DisplayName("모든 정보 출력")
    void showallinforTest(){

        Map<Integer,Trade> tradeMap = repository.findAll();

        for (Integer i : tradeMap.keySet()) {
            System.out.println(tradeMap.get(i));
        }

        assertEquals(tradeMap.size(),9);
    }

}