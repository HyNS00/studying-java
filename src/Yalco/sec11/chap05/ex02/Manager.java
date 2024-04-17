package Yalco.sec11.chap05.ex02;

public class Manager implements Runnable{
    CoffeeMachine coffeeMachine;

    public Manager(CoffeeMachine coffeeMachine){
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void run(){
        while(true){
            coffeeMachine.fill();
        }
    }
}
