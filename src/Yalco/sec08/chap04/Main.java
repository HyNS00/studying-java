package Yalco.sec08.chap04;

import Yalco.sec07.chap04.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 이터레이터
        // java.lang.Iterable
        // 컬렉션을 순회하는데 사용
        Set<Integer> intHSet = new HashSet<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9)
        );

        // 이터레이터 반환 & 초기화
        Iterator<Integer> intItor = intHSet.iterator(); // Integer형태를 순회할 때 필요

        Integer int1 = intItor.next();
        Integer int2 = intItor.next();
        Integer int3 = intItor.next();

        // hasNext :순회의 종료 여부 -> 아직 남아있다면 true, 없다면 false
        boolean hasNext = intItor.hasNext();

        // 순회 초기화 -> 다시 설정해주면 된다.
        intItor = intHSet.iterator();

         // remove : 현 위치의 요소를 삭제한다.
        while(intItor.hasNext()){
            if (intItor.next() % 3  == 0){
                intItor.remove();
            }
        } // for each 문은 오류가 생긴다


        // 왜?? -> 중간에 collection의 크기가 변동되기 때문
//        for (Integer num : intHSet){
//            if(num %3 == 0){
//                intHSet.remove(num);
//            }
//        }


        // iterator를 활용
        List<Unit> enemies = new ArrayList<>(
                Arrays.asList(
                        new Swordman(Side.RED),
                        new Knight(Side.RED),
                        new Swordman(Side.RED),
                        new Swordman(Side.RED),
                        new Knight(Side.RED),
                        new Knight(Side.RED),
                        new Swordman(Side.RED),
                        new MagicKnight(Side.RED),
                        new Swordman(Side.RED),
                        new MagicKnight(Side.RED),
                        new Knight(Side.RED),
                        new MagicKnight(Side.RED))
        );

        Iterator<Unit> enemyItor = enemies.iterator();


        int thunderBolts = 3;
        int fireBalls = 4;

        while (enemyItor.hasNext() && thunderBolts-- > 0){
            Unit enemy = enemyItor.next();
            System.out.printf("%s 벼락 공격%n", enemy);
            enemy.hp -= 50;

        }
        while (enemyItor.hasNext() && fireBalls-- > 0){ // 하나씩 줄여가면서
            Unit enemy = enemyItor.next(); //다음 enemy
            System.out.printf("%s 파이어볼 공격%n", enemy);
            enemy.hp -= 30;
        }

        while (enemyItor.hasNext()){
            Unit enemy = enemyItor.next();
            System.out.printf("%s 화살 공격%n", enemy);
            enemy.hp -= 10;
        }


        Map<Integer, Double> hasMap = new HashMap<>();
        for (int i = 0; i < 10; i++){
            hasMap.put(i+1, Math.random() * 10);
        }
        // 맵의 경우에는 자료형의 선언이 조금은 다르다.
        //  Key, Value, Entry 같은 형태의 컬렉션을 반환받는다.

        Iterator<Integer> hmKeyItor = hasMap.keySet().iterator();
        Iterator<Double> hmValueItor = hasMap.values().iterator();
        Iterator<Map.Entry<Integer,Double>> hmEntryItor = hasMap.entrySet().iterator();


        while (hmKeyItor.hasNext()){
            System.out.println(hmKeyItor.next());
        }

        while(hmValueItor.hasNext()){
            System.out.println(hmValueItor.next());
        }

        while(hmEntryItor.hasNext()){
            System.out.println(hmEntryItor.next());
        }

        //  ⭐ 이들은 따로 반환된 컬렉션의 이터레이터
        //  - 여기서 remove하는 것은 원본 맵에 영향 끼치지 않음
        while (hmKeyItor.hasNext()) {
            int i = hmKeyItor.next();
            if (i % 3 == 0) hmKeyItor.remove();
        }
        while (hmValueItor.hasNext()) {
            double d = hmValueItor.next();
            if (d < 5) hmValueItor.remove();
        }
        while (hmEntryItor.hasNext()) {
            Map.Entry<Integer, Double> e = hmEntryItor.next();
            if (e.getKey() % 2 == 0) {
                hmEntryItor.remove();
            }
        }

    }
}
