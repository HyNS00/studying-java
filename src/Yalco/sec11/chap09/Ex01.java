package Yalco.sec11.chap09;

import java.util.HashMap;
import java.util.Map;

public class Ex01 {
    public static void main(String[] args) {
        //  3개의 쓰레드에서 한 해시맵에 10000개의 데이터를 주입

        Map<String, Integer> hashMap = new HashMap<>();

        Runnable toHashMap = () -> {
            for (int i = 0; i < 10000; i++) {
                hashMap.put("key" + i, i);
            }
        };

        Thread t1 = new Thread(toHashMap);
        Thread t2 = new Thread(toHashMap);
        Thread t3 = new Thread(toHashMap);

        t1.start(); t2.start(); t3.start();

        try {
            t1.join(); t2.join(); t3.join();
        } catch (InterruptedException e) {}
    }

    // 원하는 결과인 10000이 나오지 않음
    // 요소는 10000개 존재하지만 size필드값을 올리는 것에서 문제가 발생한다
    // Thread -safe하지 않는다.

}
