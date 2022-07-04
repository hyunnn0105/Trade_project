package com.jdbc.trade.tradepost.view;

import com.jdbc.trade.tradepost.controller.TradeController;
import com.jdbc.trade.tradepost.domain.Trade;

import java.util.List;
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
                    findsomeinfor();
                    break;
                case 3:
                    showAllinfor();
                    break;
                case 4:
                    updatePostNum();
                    break;
                case 5:
                    deleteinfor();
                case 9:
                    System.out.println("시스템 종료");
                    System.exit(0);
                    return;
                default:
                    System.out.println("다시입력");
            }


        }
    }

    private void deleteinfor() {
        System.out.println(" 삭제 할 번호를 입력하세요");
        int num = inputN(">> ");

        if (tradeController.findSomeinfor(num)!=null){
            boolean flag = tradeController.deleteinfor(num);
            if (flag){
                System.out.println(" 삭제가 완료되었습니다.");
            }else {
                System.out.println(" 삭제에 실패했습니다.");
            }
        } else {
            System.out.println(" 해당 번호는 존재하지 않는 번호입니다.");
        }
    }

    private void updatePostNum() {
        System.out.println("========= 운송장번호 등록하기 ===========");
        System.out.println("운송장 번호를 등록할 번호를 입력하세요");
        int num = inputN(">> ");

        if (tradeController.findSomeinfor(num) != null){
            System.out.println("등록하실 운송장번호를 입력해주세요");
            String postNum = inputS(" - 운송장번호 : ");

            boolean flag = tradeController.updatePostinfor(postNum, num);
            if (flag){
                System.out.println("수정이 완료되었습니다.");
            } else {
                System.out.println("수정이 실패했습니다.");
            }

        } else {
            System.out.println("해당 번호는 존재하지 않는 번호입니다.");
        }
    }

    private void showAllinfor() {

        List<Trade> trades = tradeController.findAllinformation();

        System.out.println("========= 모든 회원 정보 ============\n");

        System.out.println("-------------------------------------------- 조회결과 ----------------------------------------");
        System.out.println("번호      이름    종류      가격     휴대폰번호    배송방법                 주소                     운송장번호");

        for (Trade t : trades) {
            System.out.printf( "%4d | %4s | %4s | %6d | %11s | %4s | %30s | %15s\n"
                    ,t.getTraNu() ,t.getTraNm() ,t.getItem() ,t.getPrice() ,t.getTraPhone() ,t.getPostMethod()
            ,t.getPostAddr() ,t.getPostNum());
        }



    }

    private void findsomeinfor() {
        System.out.println("조회할 회원의 번호를 입력하세요.");
        int num = inputN(">> ");

        Trade trade = tradeController.findSomeinfor(num);
        if (trade != null){
            System.out.println("\n조회결과");
            System.out.println(" - 번호 : " + trade.getTraNu());
            System.out.println(" - 이름 : " + trade.getTraNm());
            System.out.println(" - 종류 : " + trade.getItem());
            System.out.println(" - 가격 : " + trade.getPrice());
            System.out.println(" - 휴대폰 번호 : " + trade.getTraPhone());
            System.out.println(" - 배송방법: " + trade.getPostMethod());
            System.out.println(" - 주소: " + trade.getPostAddr());
            System.out.println(" - 운송장번호: " + trade.getPostNum());

        }else {
            System.out.println("\n 해당 회원은 존재하지 않습니다.");
        }
    }

    private void insetinformation() {


        System.out.println("================================");
        System.out.println("배송정보 추가");
        int number = inputN("번호 : ");
        if (tradeController.findSomeinfor(number)!=null){
            System.out.println("이미 존재하는 번호입니다. 다시 입력해주세요");
            return;
        }
        String name = inputS("이름 : ");
        String item = inputS("종류 : ");
        int price = inputN("가격 : ");
        String phone = inputS("휴대폰 번호('-'없이 입력하세요) : ");
        String postMethod = inputS("배송방법 : ");
        String postAddr = inputS("주소 : ");
        String postNum = inputS("등록할 운송장번호가 없으면 0을 입력하세요\n운송장번호 : ");


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

        System.out.println(number + "번" + name +"님이 저장되었습니다.");

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
        String s;
        while (true){
            System.out.print(msg);
            sc.nextLine();
            s = sc.nextLine();
            break;
        }
        // nextline으로 해야 띄어쓰기해도 안넘어간다....
        return s;
    }
}
