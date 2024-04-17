package Yalco.sec05.chap09.ex01;

public class PolarBear extends Mamal implements Hunter,Swimmer{
    // 상속은 한개 , 인터페이스는 여러개 가능
    // 속성같은 것 , 북극곰은 포유류에 속하며 사냥+수영의 속성을 가짐
    public PolarBear() {
        super(false);
    }
    @Override
    public void hunt() {
        System.out.println(position + ": 물범 사냥");
    }

    @Override
    public void swim() {
        System.out.println("앞 발로 수영");
    }
}
