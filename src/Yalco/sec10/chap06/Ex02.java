package Yalco.sec10.chap06;

import java.util.Optional;
import java.util.Random;
public class Ex02 {
    public static void main(String[] args) {
        //Optional<T> 클래스를 사용해 NPE를 방지할 수 있도록 도와준다. Optional<T>는 null이 올 수 있는 값을 감싸는 Wrapper 클래스로,
        // 참조하더라도 NPE가 발생하지 않도록 도와준다. Optional 클래스는 아래와 같은 value에 값을 저장하기 때문에
        // 값이 null이더라도 바로 NPE가 발생하지 않으며, 클래스이기 때문에 각종 메소드를 제공해준다.
        //출처: https://mangkyu.tistory.com/70 [MangKyu's Diary:티스토리]

        // Optional 만들기
        // of: 담으려는 것이 확실하게 존재할 때
        Optional<String> catOpt = Optional.of("cat");
//        catOpt = Optional.of(null);
        // of로 null을 담을시 npe발생

        // ofNullable :담으려는 것이 null일 수도 있을 때
        Optional<String> dogOpt = Optional.ofNullable("dog");
        Optional<String> cowOpt = Optional.ofNullable(null); // 확인해보면 Optional.empty() 로 value값은 null
        // 명시적으로 null을 담으려면 empty메소드 사용
        Optional<String> henOpt = Optional.empty();

        catOpt = getCatOpt();

    }

    public static Optional<String> getCatOpt() {
        return Optional.ofNullable(
                new Random().nextBoolean() ? "cat" : null
        );
    }
}
