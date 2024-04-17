package Yalco.sec07.chap04;

public class Knight extends Swordman{
    private enum Weapon {
        SWORD,
        SPEAR
    }
    private Weapon weapon = Weapon.SWORD; // 기본값을 검으로 작성

    public Knight(Side side){
        super(side); // 먼저 상속을 받아 체력 80을 만들어준다.
        hp += 40;  // 그 다음 40을 더 해 120을 만들어준다. 순서 중요
    }

    public void switchWeapon(){
        if (weapon == Weapon.SWORD){
            weapon = Weapon.SPEAR;
        } else{
            weapon = Weapon.SWORD;
        }
    }

    private void spearAttack(Unit target){
        target.hp -= 14;
    }

    @Override
    public void defaultAttack(Unit target){
        if (weapon == Weapon.SWORD){
            super.defaultAttack(target);
        } else{
            spearAttack(target);
        }
    }

    @Override
    public String toString(){
        return side.toString() + "진영 기사";
    }
}
