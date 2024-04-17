package Yalco.sec11.chap06.ex01;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // 쓰레드 풀 관리 라이브러리
        // 갯수제한
        ExecutorService es = Executors.newFixedThreadPool(5);

        Cave cave = new Cave();

        while(cave.getWater() > 20){
            // execute :Runnable을 대기열에 추가
            es.execute(new VolunteerRun(cave));
            try { Thread.sleep(500);
            } catch (InterruptedException e) { return; }
        }
//        es.shutdown(); // 이미 실행된 스레드가 종료될 때까지 기다림
        // es.execute(new VolunteerRun(cave)) 닫혔으므로 추가 삽입은 에러 발생

        //  💡 shutdownNow : 풀 닫고 투입된 지원자 해산, 진행중인 업무 강제종료
        //  - ⚠️ 진행중인 업무 강제종료는 보장하지 않음
        //    - 각 쓰레드에 InterruptedException을 유발할 뿐<중요>
        //    - 각 Runnable에서 해당 예외 발생시 종료되도록 처리해주어야 함
        //  - 투입되어 대기중인 지원자들은 리스트 형태로 반환
       List<Runnable> waitings = es.shutdownNow(); // 작업중이던 것들을 취소하고 종료시킴,
        // 취소된 작업 목록들이 나온다.
        System.out.println(waitings);
    }
}
