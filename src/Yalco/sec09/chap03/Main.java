package Yalco.sec09.chap03;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // 메소드 참조
        //  람다식이 어떤 메소드 하나만을 호출할 때 코드를 간편화 -> 해당 람다식과 메소드의 의미가 같을 때
        // 메소드가 인터페이스와 인자 리턴 값의 구성이 동일 할 때

        // 클래스 메소드 호출
        // {클래스명} :: {클래스 메소드명}

        // 인스턴스 메소드 호출
        // {클래스명} :: {인스턴스 메소드 명}
        // {인스턴스} :: {인스턴스 메소드 명}

        // 클래스 생성자의 호출
        // {클래스} :: new

        Function<Integer, String> intToStrLD = (i) -> String.valueOf(i);
        // 메소드 참조로 바꿈
        Function<Integer,String> intToStrMR = String::valueOf;
        String intToStr = intToStrMR.apply(123);

        UnaryOperator<String> toLCaseLD = s -> s.toLowerCase();
        UnaryOperator<String> toLCaseMR = String::toLowerCase;
        String toLCase = toLCaseMR.apply("HELLO");

        // 클래스의 생성자 실행
        Function<String,Button> strToButtonLD = s -> new Button(s);
        Function<String,Button> strToButtonMR = Button :: new;
        Button button1 = strToButtonMR.apply("Dog");

        BiFunction<String,String, Button> twoStrToButtonLD = (s1,s2) -> new Button(s1,s2);
        BiFunction<String , String,Button> twoStrToButtonMR = Button :: new;
        Button button2 = twoStrToButtonMR.apply("고양이","야옹");
        button2.onClick();

        System.out.println("\n - - - - - - - - - \n");
        // 현존하는 인스턴스의 메소드 실행
        Runnable catCryLD = () -> button2.onClick();
        Runnable catCryMR = button2 :: onClick;
        catCryMR.run();


    }
}
