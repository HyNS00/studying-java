package Yalco.sec05.chap02.ex01;

public class Slime {
    double hp = 50;
    int attack = 8;
    double defense = 0.2;

    void attack (Slime enemy){
        // Slime enemy라는 것은 Slime이라는 객체 이름명은 enemy
        // 즉 다른 슬라임 객체를 인자로 받는다.
        enemy.hp -= attack * (1 - enemy.defense);
    }
}
