package Yalco.sec05.chap08.ex01;

public abstract class YalcoGroup{
    protected static final String CREED = "우리의 %s 얄팍하다";

    // 클래스의 메소드는 abstract 불가
    protected final int no;
    protected final String name;

    public YalcoGroup(int no, String name){
        this.no = no;
        this.name = name;
    }

    public String intro() {
        return "%d호 %s점입니다.".formatted(no,name);
    }
    // 추상 메소드
    // 해당 메소드는 YalcoGroup의 하위 클래스는 모두 가져야한다.
    public abstract void takeOrder();

}
