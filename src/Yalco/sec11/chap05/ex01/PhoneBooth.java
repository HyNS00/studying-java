package Yalco.sec11.chap05.ex01;

public class PhoneBooth {
     synchronized public void phoneCall(SoldierRun soldier) {
        System.out.println("☎️ %s 전화 사용중...".formatted(soldier.title));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        System.out.println("👍 %s 전화 사용 완료".formatted(soldier.title));
//         notifyAll();
//         try {
//             //  💡 현 사용자를 폰부스에서 내보냄
//             //  - sleep처럼 아래의 예외 반환 확인
//             wait();
//         } catch (InterruptedException e) {
//             throw new RuntimeException(e);
//         }
    }
}