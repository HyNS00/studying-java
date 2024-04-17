package Yalco.sec05.chap06.ex00;

public class ToggleButton extends Button {
    private boolean on;

    public ToggleButton(String print, boolean on) {
        super(print);
        this.on = on;
        // 부모의 메소드를 필드를 필요로하는 경우에는 먼저 부모의 것을 받아야한다.
    }

    @Override
    public void func() {
        super.func(); // 부모에서 호춯한 메소드
        this.on = !this.on;
        System.out.printf("대문자 입력:" + (this.on ? "ON" :"OFF"));
    }

}
