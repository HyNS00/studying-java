package Yalco.sec13.chap04.ex01;

public class NoUse {
    // static블록 초기화
    static {
        System.out.println("초기화 완료");
        // static블록은 해당클래스가 호출 될 때 한번만 실행
    }

    public NoUse() {
        System.out.println("test");
    }
}
