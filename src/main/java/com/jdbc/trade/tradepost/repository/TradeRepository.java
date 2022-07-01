package com.jdbc.trade.tradepost.repository;

import com.jdbc.trade.tradepost.domain.Trade;

import java.util.Map;

public interface TradeRepository {
    // 1. 입력받기
    boolean inputinformation(Trade trade);

    // 2. 전체조회하기
    Map<Integer,Trade> findAll();

    // 3. 특정인물 조회하기
    Trade findSomeone(int traNu);

    //배송방법별로 조회?
//    boolean findPostaddr(String postMethod);

    // 4. 운송장번호 업데이트하기
    boolean updatePostNum(String postnum, int tranu);

    // 5. 삭제하기
    boolean delete(int traNu);


}
