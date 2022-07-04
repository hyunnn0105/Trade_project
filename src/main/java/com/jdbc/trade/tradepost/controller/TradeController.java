package com.jdbc.trade.tradepost.controller;

import com.jdbc.trade.tradepost.domain.Trade;
import com.jdbc.trade.tradepost.repository.TradeOracleRepo;
import com.jdbc.trade.tradepost.repository.TradeRepository;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeController {
    // 데이터 전처리??

    private static Map<Integer, Trade> tradeMap;

    private final TradeRepository tradeRepository;
    // 생성자 추가
    public TradeController() {
        this.tradeRepository = new TradeOracleRepo();
    }

    static {
        tradeMap = new HashMap<>();
    }

    public void insetinfor(Trade trade){
        // 메모리 저장
        tradeMap.put(trade.getTraNu(), trade);

        // db 저장
       boolean result = tradeRepository.inputinformation(trade);
//        System.out.println("result = " + result);
    }

    public List<Trade> findAllinformation(){
        // 전체조회
        Map<Integer, Trade> data = tradeRepository.findAll();
        tradeMap = data;

        List<Trade> tradeList = new ArrayList<>();
        for (Integer tradeNum : tradeMap.keySet()) {
            tradeList.add(data.get(tradeNum));
        }
        return tradeList;

    }

    public Trade findSomeinfor(int traNu){
        return tradeRepository.findSomeone(traNu);
    }

    /*
    public boolean findnum(int traNu){
        Trade findnum = findSomeinfor(traNu);
        int result = findnum.getTraNu();
        if (traNu = findSomeinfor(findnum.getTraNu()))
        return ;
    }

     */

    public boolean updatePostinfor(String postnum, int tranu){
        return tradeRepository.updatePostNum(postnum,tranu);
    }

    public boolean deleteinfor(int traNu){
        return tradeRepository.delete(traNu);
    }









}
