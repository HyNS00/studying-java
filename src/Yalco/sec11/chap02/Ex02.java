package Yalco.sec11.chap02;

public class Ex02 {
    public static void main(String[] args) {
        Thread thr0 = new Thread(new PrintThrNoRun(0));
        Thread thr1 = new Thread(new PrintThrNoRun(1));
        Thread thr2 = new Thread(new PrintThrNoRun(2));


        // 쓰레드의 우선순위를 정해주자
        // 기본적으론 우선순위는 같다
        // 제공해주는 값들은 1 ~ 10

        // 클 수록 우선순위가 높다, 자세한 값은 ctrl+클릭 + 직접 숫자 선정
//        thr0.setPriority(Thread.MAX_PRIORITY);
//        thr1.setPriority(Thread.NORM_PRIORITY);
//        thr2.setPriority(Thread.MIN_PRIORITY);
        thr0.setPriority(Thread.MAX_PRIORITY);
        thr1.setPriority(Thread.NORM_PRIORITY);
        thr2.setPriority(Thread.MIN_PRIORITY);
        // 우선순위는 말그대로 우선순위를 정해주는거지 os내부에서 실행 순서를 확정 짓지는 않는다.

//        thr0.start();
//        thr1.start();
//        thr2.start();

        // yield -> 같은 우선 순위일 경우 다른 쓰레드에게 양보한다.
        new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.print(3);
            }
            for (int j = 0; j < Integer.MAX_VALUE; j++) {}
            Thread.yield();
        }).start(); // 양보해주는 쓰레드 정의 및 실행

        for (int i = 0; i < 20; i++) {
            System.out.print('M');
            for (int j = 0; j < Integer.MAX_VALUE; j++) {}
        }
        //  ⭐ yield 역시 힌트만 줄 뿐 결정은 OS가 내림
    }
}
