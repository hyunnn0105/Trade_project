package com.jdbc.trade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectTest {
    @Test
    @DisplayName("테스트는 정상실행되어야한다.")
    void conTest(){
        Connection conn = Connect.makeConnection();

        if (conn != null){
            System.out.println("연결성공");
        } else {
            System.out.println("연결실패");
        }
        assertNotNull(conn);
    }

}