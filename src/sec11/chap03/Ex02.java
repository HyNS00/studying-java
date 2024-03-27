package sec11.chap03;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        ThreadGroup groupA = new ThreadGroup("A");
        ThreadGroup groupB  = new ThreadGroup("B");
        ThreadGroup groupBB = new ThreadGroup(groupB,"BB");
        ThreadGroup groupC = new ThreadGroup("C");
        ThreadGroup[] thrg = {groupA, groupB, groupBB, groupC };
        for (ThreadGroup tg : thrg){
            for (int i = 0; i < 3; i++){
                new Thread(tg,new PrintThread(tg.getName())).start();
            }
        }
        try (Scanner sc = new Scanner(System.in)){
            while(sc.hasNext()){
                String line = sc.nextLine();
                if(line.length() == 1){
                    ThreadGroup[] groups = new ThreadGroup[]{
                            groupA,groupB,groupC
                    };
                    if("abc".contains(line)){
                        ThreadGroup group = groups["abc".indexOf(line)];

                        // 그룹의 현황파악
                        System.out.printf(
                                "%s : %d / %d%n",
                                group.getName(), group.activeCount(),group.activeGroupCount()
                                // 내부의 쓰레드가 멈춰도 active로 카운트
                                //activeGroupCount() 메서드는 그룹 내의 모든 스레드가 멈춰있어도 스레드 그룹의 수를 반환합니다.
                                // 따라서 스레드 그룹 내의 스레드가 활성화되거나 실행 중이 아니더라도,
                                // 해당 그룹이 아직 제거되지 않았다면 그룹은 여전히 활성 상태로 간주됩니다.

                        );
                    }
                    if("ABC".contains(line)){
                        ThreadGroup group = groups["ABC".indexOf(line)];
                        group.interrupt();
                    }
                }
                if(line.equalsIgnoreCase("quit")) break;
            }
        }

    }
}
