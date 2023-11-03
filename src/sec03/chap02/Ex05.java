package sec03.chap02;

public class Ex05 {
    public static void main(String[] args) {
        int i1 =5;
        float f1 = 2f;
        double db1 = 3;
        double db2 = 7;

        // 정수 자료형과 실수 자료형의 계산은 실수 반환
//        int f2 = int 1/ f1; //불가
        double d3 = i1 / db1;
        double d4 = db1/ i1;

        // 리터럴로 작성시 double임을 명시하려면 .0을 붙인다

        double d5 = 5/2; // 결과가 2, why? 둘이 정수라서 int결과계산 2.5가 나오려면 .0을 붙임
        double d6 = 5.0 /2;
        double d7 = 5/ 2.0;

        float fltNum = 4.567f;
        double dblNum = 5.678;

        // 정수 자료형에 강제로 집어넣으면 소수부를 버림
        int int2 = (int) fltNum;
        int int3 = (int) dblNum;
    }
}
