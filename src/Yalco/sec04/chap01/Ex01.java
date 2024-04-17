package Yalco.sec04.chap01;

public class Ex01 {
    public static void main(String[] args) {
        // if else문
        boolean open = true;
        int saleFrom = 10, saleTo = 20;
        int today = 15;


        // if : 괄호 안에 boolean 값이 true면 실행
        if (open) System.out.println("영업중");
        if (!open) System.out.println("영업 종료");

        // 실행할 명령이 한 줄 이상일 경우

        if (today >= saleFrom && today <= saleTo) {
            System.out.println("세일 중입니다");
            System.out.println("20%할인");
        }

        //  💡 else : if문 안의 boolean 값이 false일 경우 실행
        if (open) {
            System.out.println("영업중");
        } else {
            System.out.println("영업종료");
        }
    }
}
