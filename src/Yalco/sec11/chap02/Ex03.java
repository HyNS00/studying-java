package Yalco.sec11.chap02;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        // 쓰레드를 이용한 멀티태스킹
        Thread tarzanSong = new Thread(new TarzanRun(15));
        tarzanSong
//                .run(); // 멀티 안됨, 일단 작동
        // 해당 쓰레드가 종료되고 나서야 입력받음
                .start();

        try(Scanner sc = new Scanner(System.in)){
            while(sc.hasNext()){
                String line = sc.nextLine();
                // 조건문 1
                if(line.equalsIgnoreCase("aaa")){
                    System.out.println("진행 중입니까?");
                    System.out.println(
                            // isAlive() -> 해당 스레드가 진행중임을 물어봄
                            tarzanSong.isAlive() ? "예" : "아니요"
                    );
                }
                // 조건문 2
                if(line.equalsIgnoreCase("d")){
                    System.out.println("join했습니다");
                    //  💡 해당 쓰레드의 차로로 들어가서(join) - 비유적 표현
                    //  그 쓰레드의 작업이 다 끝날 때까지 기다림 -> 즉 입력한것이 바로 출력되는게 아니라 tarzan이 끝나야 한번에 나옴
                    //  ⚠️ catch 블록 요구됨 - InterruptedException 처리
                    try{
//                        tarzanSong.join();
                        tarzanSong.join(500); // 해당 숫자만큼만 대기한다.
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
                // 조건문 3
                if(line.equalsIgnoreCase("s")){
                    System.out.println("멈추기");
                    //  TarzanRun 클래스의 🛑 아래 코드 주석해제해야 함
                    //  💡 해당 쓰레드의 run에 InterruptedException 발생시킴
                    //  - sleep 등에 의해 정지 상태에 있을 때
                    //    - sleep 메소드가 해당 예외를 던지는 이유
                    //  - 강제하는 것이 아니라 메시지를 던지는 것
                    //    - 해당 쓰레드에서 받아주어야 함
                    tarzanSong.interrupt(); // interrupt catch문에서 잡음

                    //  ⭐️ 과거에는 쓰레드를 강제종료하는 stop을 사용했음
                    //  - 위험했기 때문에 deprecated
                    //    - 데이터 오염, 리소스 누수 등
                    //  - suspend, resume 등도 마찬가지
                }
                if (line.equalsIgnoreCase("quit")){

                    // 🤓 .equalsIgnoreCase( )은 대소문자를 무시하고 같은 지 비교
                    // .equals( )은 대소문자를 다르게 판단
                    break; // 입력 받는것을 종료

                }
                System.out.println(line);
            }
        }
    }
}
