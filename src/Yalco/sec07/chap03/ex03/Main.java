package Yalco.sec07.chap03.ex03;

import Yalco.sec05.chap09.ex01.*;

public class Main {
    public static void main(String[] args) {
        double sum1 = add2Num(3.14,23.3);
        // double sum2 = add2Num("1", true); 불가

        descHuntingMamal(new PolarBear());
//        descHuntingMamal(new GlidingLizard()); // ⚠️ 불가

        descFlyingHunter(new Eagle());
        descFlyingHunter(new GlidingLizard());
//        descFlyingHunter(new PolarBear()); // ⚠️ 불가
    }

    // T는 Number를 상속한 클래스이어야 한다는 조건
    public static <T extends Number> double add2Num(T a, T b){
        return a.doubleValue() + b.doubleValue();
    }

    // 응용
    // 상속받는 클래스와 구현받는 인터페이스들을 함께 조건으로 extends 뒤에 &로 나열
    public static <T extends Mamal & Hunter & Swimmer> void descHuntingMamal (T animal){
        // 해당 조건에 해당하는 자료형만이 올 수 있음
        System.out.printf("겨울잠 %s%n", animal.hibernation ? "잠" : "자지 않음");
        animal.hunt();
    }

    public static <T extends Flyer & Hunter> void descFlyingHunter (T animal){
        animal.fly();
        animal.hunt();
    }

}
