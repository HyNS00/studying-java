package Yalco.sec04.chap05;

public class Ex01 {
    public static void main(String[] args) {
        // 자바에서 function역할을 하는 것  = method
        double xx = 3, yy= 4;
        addSubMultiDiv(xx,yy);

        xx =10; yy = 2;
        addSubMultiDiv(xx,yy);
        xx = 7; yy = 5;
        addSubMultiDiv(xx, yy);
        // 처음 선언할 때는 xx,yy같이 콤마를 통해서 선언하지만
        // 그 다음은 세미콜론으로 값을 바꿔줄 수 있다
    }
    // 메인 method 밖에 설정을 한다
    static void addSubMultiDiv (double a, double b) {
        System.out.printf("%f + %f = %f%n", a, b, a + b);
        System.out.printf("%f - %f = %f%n", a, b, a - b);
        System.out.printf("%f * %f = %f%n", a, b, a * b);
        System.out.printf("%f / %f = %f%n", a, b, a / b);
    }
}
