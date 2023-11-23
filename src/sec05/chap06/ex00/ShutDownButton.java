package sec05.chap06.ex00;

public class ShutDownButton extends Button {
    public ShutDownButton () {
        super("Shut Down"); // 부모의 생성자를 호출
    }

    // 부모의 메소드를 override
    @Override
    public void func () {
        System.out.println("프로그램 종료");
    }
}
