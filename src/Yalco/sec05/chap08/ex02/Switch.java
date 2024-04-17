package Yalco.sec05.chap08.ex02;

public class Switch extends FormElement{
    private boolean on;

    public Switch(int space, boolean on){
        super(space);
        // FormElement의 생성자는 반드시 먼저 호출해줘야한다.
        this.on = on;
    }

    @Override
    void func(){
        on = !on; // on,off 변경
        System.out.println((on ? "ON" : "OFF") + "으로 전환");
    }
}
