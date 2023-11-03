package sec03.chap02;

public class Ex04 {
    public static void main(String[] args) {
        float f1 = 4.124f;
        float f2 = 4.125f;
        double db01 = 3.5;

        // float끼리의 연산은 float반환
        float f3 = f1 + f2;

        // float + double = double반환
//        float f4 = f1 + d1;
        //  부동소수점 방식상 오차 자주 있음
        double dbl02 = 0.2 + 0.3f;
        double dbl03 = 0.2f * 0.7f;
        double dbl04 = 0.4 - 0.3;
        double dbl05 = 0.9f / 0.3;
        double dbl06 = 0.9 % 0.6;

        //  소수부가 2의 거듭제곱인 숫자간 연산은 오차 없음
        double dbl07 = 0.25 * 0.5f;
        double dbl08 = 0.5 + 0.25 + 0.125 + 0.0625;
        double dbl09 = 0.0625f / 0.125;
    }
}
