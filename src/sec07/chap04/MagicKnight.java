package sec07.chap04;

public class MagicKnight extends Knight {
    public int mana = 60; // 변하는 값
    public final int MANA_USAGE = 4; // 소비량은 변하지 않으니까 4

    public MagicKnight(Side side){
        super(side); // Knight와 체력도 같다.
    }

    public void lighteningAttack (Unit[] targets){
        for (Unit target : targets){
            if (target instanceof MagicKnight){
                continue;
            } // 메소드 1
            if (mana < MANA_USAGE){
                break;
            } // 메소드2

            System.out.printf("⚡ -> ☢️%s%n", target);
            target.hp -= 8;
            mana -= MANA_USAGE; // 메소드 3 구성 가능
        }
    }

    @Override
    public String toString(){
        return side.toString() + "진영 마법기사";
    }
}
