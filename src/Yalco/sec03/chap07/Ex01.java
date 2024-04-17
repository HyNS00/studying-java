package Yalco.sec03.chap07;

public class Ex01 {
    public static void main(String[] args) {
        // 포메팅
        String str1 = "%s의 둘레는 반지름 X %d X %f입니다.";
        String circle  ="원";
        int two = 2;
        double PI = 3.14;

        // formatted  : 주어진 형식에 따라 문자열 생성
        String str2 = str1.formatted(circle,two,PI);


        // 13이전 버전에서 포매팅
        String str3 = String.format(str1,circle,two, PI);

        // 포메팅 형식
        // %b 불리언, %d 10진수정수, %f 실수, %c 문자, %s 문자열
        // %n -> 포맷 문자열 내 엔터 역할을 한다

        // format을 쓰는 것도 좋지만 printf 형식을 사용하자
        // 파이썬과 같이 줄바꿈이 되지 않으므로 %n을 넣어줘야한다
        // 흔히 쓰이는 sout (println)은 변수를 그대로 표현 , 포매팅이 안됨
        System.out.printf("%s의 둘레는 반지름 X %d X %.2f이다",circle,two,PI);

    }
}
