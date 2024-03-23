package sec11.chap02;

public class Main {
    public static void main(String[] args) {
        Thread tarazanThread = new Thread(new TarzanRun(10));

        // Thread의 이름 붙이기
        tarazanThread.setName("타잔 Thread");
        tarazanThread.start(); // 타잔 스레드 시작


    }
}
