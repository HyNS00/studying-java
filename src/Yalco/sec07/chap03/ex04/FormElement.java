package Yalco.sec07.chap03.ex04;

public abstract class FormElement {
    public enum Mode {
        LIGHT,
        DARK
    }

    private static Mode mode = Mode.LIGHT;
    public void printMode(){
        System.out.println(mode);
    }
    // 추상 메서드 구현
    abstract void func();

}
