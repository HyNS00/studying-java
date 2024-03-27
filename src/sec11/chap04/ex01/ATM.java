package sec11.chap04.ex01;

import java.util.Random;
// 동기화를 하지 않으면 쓰레드에서 동시다발적으로 접근하여
// 원하는 결과가 나타나지 않을 수도 있다
// synchronized를 활용해서 한 쓰레드가 점유하고 있을 때는 점유하지 못하게 한다.

public class ATM {
    private int balance = 0;
    public void addMoney(int amount){
        balance += amount;
    }

    public int getBalance(){
        return balance;
    }
    // 동기화 1.
    // 앞에 synchronized를 붙인다
    public void withdraw(String name, int amount){

        // 아래 내용을 이 블록으로 옮겨 볼 것
        //  this는 현 쓰레드를 의미함
        //  메소드 내의 특정 작업만 동기화가 필요할 때
        synchronized (this){
            if(balance < amount){
                return;
            }

            System.out.printf(
                    "%s 인출 요청 (현 잔액 %d)%n", name, balance
            );

            try{
                Thread.sleep(new Random().nextInt(700, 1000));
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }

            balance -= amount;
            System.out.printf(
                    "%s 인출 완료 (현 잔액 %d)%n",name, balance
            );
        }

    }
}
