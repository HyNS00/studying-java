package sec07.ex04;

public class Button extends FormElement implements Clickable{
    @Override
    public void onClick(){
        func();
    }

    @Override
    void func(){ // 부모 메서드와 같은 접근제어자를 따라야한다.
        System.out.println("버튼 클릭");
    }
}
