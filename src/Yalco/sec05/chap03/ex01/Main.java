package Yalco.sec05.chap03.ex01;

public class Main {
    public static void main(String[] args) {
        // 클래스 필드와 메소드는 인스턴스를 생성하지 않고 사용
        String ycBrand = YalcoChicken.brand;
        String ycContact = YalcoChicken.contact();

        // 인스턴스 메소드 불가
        // String ycName = YalcoChicken.name;
        // String ycIntro = YalcoChicken.intro();

        YalcoChicken store1 = new YalcoChicken(3,"판교");
        String st1Intro = store1.intro();

        // 인스턴스에서는 클래스의 필드와 메소드를 사용할 수 있다.
        // 편의상 기능일 뿐, 권장하지 않는다.
        String st1Brand = store1.brand;
        String st1Contact = store1.contact();

        // 클래스자체에서 static필드를 뽑아내는건 문제가 없다
        // 그러나 객체 즉, 인스턴스 자체에서 쓰는건 문제가 있다.

    }

}
