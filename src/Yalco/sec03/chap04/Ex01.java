package Yalco.sec03.chap04;

public class Ex01 {
    public static void main(String[] args) {
        // boolean 참 / 거짓을 의미하는 자료형
        // 1바이트 공간
        boolean bool1 = true;
        boolean bool2 = false;

        // !은 반전시킨다
        boolean bool3 = !true;
        boolean bool4 = !false;

        // !는 여러개가 가능하다 -의 느낌
        boolean bool5 = !!true;
        boolean  bool6 = !!false;

        boolean bool7 = !(1 > 2);
        boolean bool8 = !((5 / 2) == 2.5);
        boolean bool9 = !((3f + 4.0 == 7) != ('A' < 'B'));
    }
}
