package sec11.chap01;

public class Thread1 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++){
            try{
                Thread.sleep(300);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.print(1);
        }

    }
}
