package TIL.복습.다형성;

public class Bus implements Vehicle{

    @Override
    public void run(){
        System.out.println("버스 운전");
    }

    public void checkFare(){
        System.out.println("승차요금 체크");
    }
}
