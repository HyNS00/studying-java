package Yalco.sec03.chap01;

public class Ex04 {
    public static void main(String[] args) {
        int a =1;
        int b = 2;

        // int끼리의 연산은 int반환
        int c = a+b;

        long d = a+b;
        // int보다 long이 더크니 (묵시적으로)가능

//        short e = a+b; // 묵시적으로 불가
        // short에 넣는 법 -> 명시적 (short)를 붙여 형변환
        short e = (short)  (a+b);
        // (short) a +b;가 안되는 이유는 a(short) +b(int)이렇게 계산됨


        byte b1 = 1;
        byte b2 = 2;
        short s1 = 1;
        short s2 = 2;

        //  ⚠️ 아래는 모두 불가
//        byte b3 = b1 + b2;
//        short s3 = b1 + b2;
//        short s4 = b1 + s2;
//        short s5 = s1 + s2;

        //  ⭐ byte와 short의 연산들은 int 반환
        //  그냥 int를 많이 쓰는 이유 중 하나
        int i1 = b1 + b2;
        int i2 = s1 + s2;
        int i3 = b1 + s1;

        long l1 = 1;
        long l2 = 2;

        // long끼리의 연산은 long반환
        long l3 = l1 + l2;

        // 정수 자료형의 계산은 소수점 아래를 '버림'
        byte int1 = 5/2;
        int int2 = 10;
        int int3 = 3;
        int int4 = int2/ int3;

        // 💡 홀수와 짝수 구분에 널리 사용
        int aa = 1 % 2;
        int bb = 2 % 2;
        int cc = 3 % 2;
        int dd = 4 % 2;
        int ee = 5 % 2;
        int ff = 6 % 2;
        int gg = 7 % 2;


    }
}
