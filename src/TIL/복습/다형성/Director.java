package TIL.복습.다형성;

public class Director extends Manager{
    @Override
    public void calcBonus(){
        System.out.println("Director 보너스 = 기본급 + 12*6");
    }
}
