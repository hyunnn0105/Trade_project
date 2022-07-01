package com.jdbc.trade.tradepost.view;

import com.jdbc.trade.tradepost.controller.TradeController;
import com.jdbc.trade.tradepost.domain.Trade;

import java.util.Scanner;

public class TradeMenu {
    private final TradeController tradeController;

    private final Scanner sc;

    public TradeMenu() {
        tradeController = new TradeController();
        sc = new Scanner(System.in);
    }

    public void mainmenu() {

        while (true) {
            System.out.println("\n============ 배송관리 프로그램 =================");
            System.out.println("# 1. 배송정보 등록하기");
            System.out.println("# 2. 배송정보 조회하기");
            System.out.println("# 3. 모든 배송정보 조회하기");
            System.out.println("# 4. 운송장번호 수정하기");
            System.out.println("# 5. 정보 삭제 하기");
            System.out.println("# 9. 프로그램 종료 ");

            int menu = inputN("메뉴입력 : ");

            switch (menu) {
                case 1:
                    insetinformation();
                    break;
                case 2:
//                    findsomeinfor();
                    break;
                case 3:
//                    showAllinfor();
                    break;
                case 4:
//                    updatePostNum();
                    break;
                case 5:
//                    deleteinfor();
                case 9:
                    System.out.println("시스템 종료");
                    System.exit(0);
                    return;
                default:
                    System.out.println("다시입력");
            }


        }
    }

    private void insetinformation() {
        System.out.println("================================");
        System.out.println("배송정보 추가");
        System.out.println();
        int number = inputN("번호 : ");
        String name = inputS("이름 : ");
        String item = inputS("종류 : ");
        int price = inputN("가격 : ");
        String phone = inputS("휴대폰 번호('-'없이 입력하세요) : ");
        String postMethod = inputS("배송방법 : ");
        String postAddr = inputS("주소 : ");
        String postNum = inputS("운송장번호: ");

        if (tradeController.findnum(number) == number){
            System.out.println("number의 숫자를 다시 입력하세요.");
        }

        Trade trade = new Trade();
        trade.setTraNu(number);
        trade.setTraNm(name);
        trade.setItem(item);
        trade.setPrice(price);
        trade.setTraPhone(phone);
        trade.setPostMethod(postMethod);
        trade.setPostAddr(postAddr);
        trade.setPostNum(postNum);

        tradeController.insetinfor(trade);

        System.out.printf("\n %d번 %s 님이 저장되었습니다.", number, name);

    }

    private int inputN(String msg) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("# 정수로만 입력하세요");
            }
        }
        return n;
    }

    private String inputS(String msg) {
        System.out.printf(msg);
        return sc.next();
    }
}
