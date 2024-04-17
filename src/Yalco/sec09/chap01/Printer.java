package Yalco.sec09.chap01;

@FunctionalInterface
public interface Printer {
    void print();
    // 👀 functionalinterface는 "추상 메소드"가 하나만 있게 제한한다.
    //  조건 : 클래스 메소드와 default메소드는 여럿 있을 수 있다. (static 메소드와 default메소드)


}
