package Yalco.sec11.chap02;

public class TarzanRun implements Runnable{
    // 새 Thread
    int max;

    public TarzanRun(int max) {
        this.max = max;
    }

    @Override
    public void run(){
        String lyric = "%s : 타잔이 %d원짜리 팬티를 입고 %d원짜리 칼을 차고 노래를 한다.";
        for(int i = 0; i < max+1; i++){
            try{
                Thread.sleep(700);
                System.out.printf(
                        (lyric) +"%n" , Thread.currentThread().getName(), i*10, (i+1)*10
                );
            } catch (InterruptedException e){
                // 🛑
                //System.out.println("네.");
                return;
            }
        }
    }
}
