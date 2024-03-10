package TIL.복습.클래스와변수;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("V5");
        Car myCar = new Car("ddd",engine);

        myCar.start();
    }
}
