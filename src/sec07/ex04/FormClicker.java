package sec07.ex04;

public class FormClicker<T extends FormElement & Clickable> {
    private T formElem;

    public FormClicker(T formElem){
        this.formElem = formElem;
    }

    //  ⭐️ 조건의 클래스와 인터페이스의 기능 사용 가능
    //  - 자료형의 범위를 특정해주므로
    // 여기에 들어갈 수 있는 formElem의 자료형은 이미 Override로 구현되어 있을 것이다.

    public void printElemMode() {
        formElem.printMode();
    }

    public void clickElem() {
        formElem.onClick();
    }
}
