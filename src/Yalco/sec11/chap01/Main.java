package Yalco.sec11.chap01;

public class Main {
    public static void main(String[] args) {
        // 쓰레드는 자원을 공유하기에 위험하다.


        // 쓰레드를 만드는 방법은 2가지
        // Thread 클래스를 상속한 쓰레드
        // Runnable을 구현한 쓰레드
        Thread thread1 = new Thread1(); // Thread상속
        Thread thread2 = new Thread(new MyRunnable()); // Runnable구현

        // 익명 클래스 활용
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run(){
                for (int i =0; i < 10; i++){
                    try{
                        Thread.sleep(300);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    System.out.print(3);
                }
            }
        });

        //  ⚠️ 해당 쓰레드에 지정된 run 메소드를
        //  현재 메인 쓰레드에서 실행
        //  - 쓰레드 사용 의미 없음
//        thread1.run();
//        thread2.run();
//        thread3.run();

        //  💡 각각 새로운 쓰레드를 생성하여 동시에 진행
        //  - 실행시마다 결과 다를 수 있음 왔다갔다 실행
        thread1.start();
        thread2.start();
        thread3.start();

        // sleep 메소드
        // Thread의 정적 메소드
        // 주어진 밀리언 초동안 해당 쓰레드를 멈춘다.

        for (int i = 0; i < 10; i++) {
            // 😴
            try {
                Thread.sleep(300); // 런타임 오류 방지로 try-catch 필요
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } // 0.3초마다 Thread를 쉬게한 뒤 넘어감
            System.out.print('M');
        }
    }
}
