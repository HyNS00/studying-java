package Yalco.sec03.chap02;

public class Ex03 {
    public static void main(String[] args) {
        // float은 뒤에 f 또는 F를 붙임
        // f를 붙이지 않을 경우, double로 인식
        float f1 = 3.14f;
        double d1 = 3.14;

        // float에는 double을 담을 수 없다.
//         float f2 = d1;
        // 명시적 형변환 필요, 반대는 가능
        double d2 = f1;

        long lng1 = 123;
        // 정수를 대입할 시 묵시적 변환
        // float(4바이트)에도 long(8바이트)의 값을 담을 수 있다.
        float f3 = lng1;
        double d3 = lng1;

        long lng2 = Long.MAX_VALUE;

        // 큰 수일 경우 -> 가능한 최대한 정확도로 표현
        float f4 = lng2;
        double d4 = lng2;

        // 복합 대입 연산자와 단항 연산자
        float f5 = 123.45f;
        f5 += 6.78;
        f5++;
        f5++;
        f5--;

    }
}
