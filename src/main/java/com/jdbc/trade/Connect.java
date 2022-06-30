package com.jdbc.trade;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    private final static String ACCOUNT = "sqld"; // 계정명
    private final static String PASSWORD = "1234"; // 비밀번호

    private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    // 데이터베이스 접속에 사용할 드라이버 클래스 - DB 회사마다 다름
    // oracle jdbc driver class name      ======패키지======   ---클래스---
    private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";


    public static Connection makeConnection(){
        // 2. 연결 정보(아이디 비번)를 담아 연결객체를 생성 + 메모리 절약? try~resource
        try {
            // 1. 드라이버 클래스를 동적 로딩 + try~catch
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, ACCOUNT, PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

}
