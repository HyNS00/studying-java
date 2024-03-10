package TIL.복습.클래스와변수;

public class Car {
    private String model;
    private Engine engine;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public void start(){
        System.out.println(model + " is starting\n" + engine.start());
    }
}
