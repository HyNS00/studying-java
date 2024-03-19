package sec10.chap03;

import sec07.chap04.*;

public class Ex05 {
    public static void main(String[] args) {
        MagicKnight magicKnight = new MagicKnight(Side.BLUE);
        Dragon dragon = new Dragon(Side.RED);

        superLigteningAttack(magicKnight, dragon);
        superLigteningAttack(magicKnight, dragon);
    }
    public static void superLigteningAttack(MagicKnight mk, Unit enemy){
        final int MANA_USAGE = 40;
        final int DAMAGE = 500;
        if(mk.mana < MANA_USAGE){
            throw new NotEnoughMana(mk, MANA_USAGE);
        }
        System.out.printf("⚡️⚡️⚡️ → 💀 %s%n", enemy);
        enemy.hp -= DAMAGE;
        mk.mana -= MANA_USAGE;
    }
}
