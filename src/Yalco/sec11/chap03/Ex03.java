package Yalco.sec11.chap03;

public class Ex03 {
    public static void main(String[] args) {
        // 데몬 스레드
        // 주 스레드를 보조해준는 역할
        // 주스레드 종료시 작업 종료
        Runnable rythmRun = () -> {
            int index = 0;
            String rythm = "쿵쿵짝";

            while(true){
                System.out.print(rythm.charAt(index++)+ " "); //해당 인덱스 마다 출력하고 띄어쓰기까지 같이 출력
                index %= rythm.length(); // 만약 인덱스가 4가 넘어갔을 경우 에러발생 -> 방지하기 위해

                try{
                    Thread.sleep(200);
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        };

        Thread SingThread = new Thread(() ->{
            String[] lines = new String[]{
                    "푸른하늘 은하수", "하얀 쪽배엔",
                    "계수나무 한나무", "토끼 세마리",
                    "한마리는 구워먹고", "한마리는 튀겨먹고",
                    "한마리는 도망간다", "서쪽나라로"
            };

            Thread rythmThread = new Thread(rythmRun);
            // rythmThread를 데몬 쓰레드로 지정함으로써 SingThread가 종료되면 같이 종료
            rythmThread.setDaemon(true);
            rythmThread.start();
            for(int i = 0; i < lines.length; i++){
                System.out.println("\n" + lines[i]);
                try{
                    Thread.sleep(1200);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }

        });

        SingThread.start();
    }


}
