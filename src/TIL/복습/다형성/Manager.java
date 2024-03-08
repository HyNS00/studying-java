package TIL.복습.다형성;

public abstract class Manager extends Employee {
    @Override
    public void calcSalary(){
        System.out.println("Manager 급여  = 기본급 + 팁 성과 보상");
    }
}
// Manager가 추상 클래스이기 때문에 Employee클래스의 모든 추상 메소드를 구현할 필요가 없다.
// Manager를 상속하는 다른 일반 클래스에서 나머지 추상 메소들르 구현해주면 해결된다.

// 이와 마찬가지인 이유로 Manager클래스가 추상메소드이기 때문에 Employee의 추상메소드를 구현하지 않고 자신의 추상메소들르
// 적어놔도 문제가 생기지 않는다
// 🙆‍♂️ 결국 전체적으로 Manager를 상속하는 일반 클래스에서 구현되지 않은 추상 메소드를 구현하면 된다.