package Yalco.sec10.chap03;

import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        // 예외 던지기 throw
//        throw new RuntimeException();

        // 메세지를 특정하여 던지기
//        throw new RuntimeException("이렇게 메세지 특정 가능");

        // 원인이 되는 다른 예외들을 명시하여 던지기
        throw new RuntimeException("이와 같은 이유로 발생"
        , new IOException( //
                new NullPointerException()
        ));
        // RuntimeException이 최종적으로 발생
        // NullPointerException이 발생했기 때문에 IOException이 발생했고, 그로인한 RuntimeException

    }
}
