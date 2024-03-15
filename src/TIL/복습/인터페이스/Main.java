package TIL.복습.인터페이스;

public class Main {
    public static void main(String[] args) {
        Test t = new Test();

        t.callPrivate();
        Sample.callPrivateStatic();
    }
}
