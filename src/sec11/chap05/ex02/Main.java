package sec11.chap05.ex02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Arrays.stream("철수,영희,돌준,병미,핫훈,짱은,밥태".split(","))
                .forEach(s -> new Thread(
                        new CustomerRun(s, coffeeMachine)
                ).start());
        // 각 이름을 가진 쓰레드 생성 - synchronized 했기에 동시다발적으로 접근을 방지

        new Thread(new Manager(coffeeMachine)).start();
    }
}
