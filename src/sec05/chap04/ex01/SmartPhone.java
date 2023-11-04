package sec05.chap04.ex01;

public class SmartPhone {
    // 캡슐화
    String powerButton = "OnOff";
    public String sdCardSlot = "SD Card";
    private String cpu = "Yalcom";


    /*
    private 는 동일 클래스 안에서만 접근이 가능하고
    public 은 다른 패키지에서도 접근이 가능하다

    powerButton의 경우  default로 같은 패키지내에서는 접근이 가능하지만
    다른 패키지에서는 접근이 불가능

     */
}
