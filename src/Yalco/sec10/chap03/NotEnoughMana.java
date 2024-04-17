package Yalco.sec10.chap03;

import Yalco.sec07.chap04.MagicKnight;

public class NotEnoughMana extends RuntimeException{
    public NotEnoughMana(MagicKnight mk ,int mana) {
        super(
                "마나가 %d 부족합니다".formatted(mana - mk.mana)
        );
    }
}
