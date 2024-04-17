package Yalco.sec11.chap06.ex02;

import java.util.Random;
import java.util.concurrent.Callable;

public class RollDiceCall implements Callable<Integer> {
    //  - Runnable과의 차이 :
    //    - 값 반환 (Supplier처럼)
    //    - Exception 던짐

    @Override
    public Integer call() throws Exception{
        Thread.sleep(1000);
        int result = new Random().nextInt(0,6) + 1;
        System.out.println(result);
        return result;
    }
}
