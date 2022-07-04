package com.jdbc.trade.tradepost.controller;

import com.jdbc.trade.tradepost.domain.Trade;
import com.jdbc.trade.tradepost.repository.TradeOracleRepo;
import com.jdbc.trade.tradepost.repository.TradeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TradeControllerTest {


    @Test
    @DisplayName("조회성공")
    void test(){


        TradeController tradeController = new TradeController();
        List<Trade> trades = tradeController.findAllinformation();


        for (Trade t : trades) {
            System.out.printf( "%d %s %s %d %s %s %s %s"
                    ,t.getTraNu() ,t.getTraNm() ,t.getItem() ,t.getPrice() ,t.getTraPhone() ,t.getPostMethod()
                    ,t.getPostAddr() ,t.getPostNum());
        }

    }

}