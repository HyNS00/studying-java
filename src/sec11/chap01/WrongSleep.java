package sec11.chap01;

import java.util.stream.IntStream;

public class WrongSleep {
    public static void main(String[] args) {
        Thread sleeper = new Thread(new Runnable() {
            @Override
            public void run(){
                IntStream.range(0,5).forEach(
                        i -> {
                            try{
                                Thread.sleep(100);
                            } catch (InterruptedException e){
                                throw new RuntimeException(e);
                            }
                            System.out.println("zzz");
                        }
                );
            }
        });
        // 방금 위의 코드를 람다식으로 한다면?
//        Thread sleeper2 = new Thread(() -> IntStream.range(0,5).forEach(i
//        -> {
//            try{
//                Thread.sleep(100);
//            } catch(InterruptedException e){
//                throw new RuntimeException(e)
//            }
//            System.out.println("zzz");
//        }));
        sleeper.start();

//        try{
//            sleeper.sleep(1000);
            // 의도 -> sleeper 인스턴스에 메소드를 적용하여 메인쓰레드를 먼저 작동하고 sleeper가 작동하게 함
            // 그러나 메인 쓰레드가 잠들어버림
            // why? 정적메소드이기 때문에 현 메소드가 잠듦
            // sleeper를 재우기 위해서는 인스턴스에 메소드를 실행하는 것이 아닌 sleeper 쓰레드 자체에 생성


//        } catch(InterruptedException e){
//            throw new RuntimeException(e);
//        }

        System.out.println("끝"); // 메인 쓰레드
    }
}
