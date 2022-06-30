package com.jdbc.trade.tradepost.domain;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Builder
public class Trade {

    private int traNu;
    private String traNm;
    private String item;
    private int price;
    private String traPhone;
    private String postMethod;
    private String postAddr;
    // integer = 값존재X -> null
    private Integer postNum;


}
