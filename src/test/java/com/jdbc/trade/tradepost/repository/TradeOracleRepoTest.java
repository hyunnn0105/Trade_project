package com.jdbc.trade.tradepost.repository;

import com.jdbc.trade.tradepost.domain.Trade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TradeOracleRepoTest {

    TradeRepository repository = new TradeOracleRepo();

    @Test
    @DisplayName("값이 들어가야한다")
    void inputTest(){
        Trade ko = new Trade();
        ko.setTraNu(4);
        ko.setTraNm("가가가");
        ko.setItem("장난감");
        ko.setPrice(13000);
        ko.setPostMethod("택배");
        ko.setTraPhone("01011112222");
        ko.setPostAddr("경기도 의왕시 00동 00길 00아파트 000동 000호");
        ko.setPostNum(1234123412);

        boolean inputtest = repository.inputinformation(ko);
        assertEquals(true, inputtest);
    }
}