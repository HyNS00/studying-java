package Yalco.sec08.chap02;

import Yalco.sec07.chap04.*;
import java.util.*;

// ctrl + R = 코드를 교체가능

public class Main_LinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> inst1 = new LinkedList<>();
        LinkedList<String> strings1 = new LinkedList<>();
        LinkedList<Number> numbers = new LinkedList<>();
        LinkedList<Knight> knights = new LinkedList<>();

        // add 메소드 -> 요소 추가 , 같은 타입만 집어넣을 수 있다.

        inst1.add(11);
        inst1.add(22);
        inst1.add(33);
        inst1.add(44);
        inst1.add(55);

        String[] strs = "바니 바니 바니 바니 당근 당근".split(" ");
        for (String str : strs){
            strings1.add(str);
        }

        // for each문
        for (int i : inst1){
            System.out.println(i);
        }

        int ints1Size = inst1.size(); // 요소 개수
        boolean ints1IsEmpty = inst1.isEmpty(); // 리스트가 비어있는지 확인
        int ints12nd = inst1.get(1); // 인덱스 요소로 접근
        boolean ints1Con3 = inst1.contains(33); // 포함하고 있는가
        boolean ints1Con6 = inst1.contains(66);

        // 위치의 요소 수정
        inst1.set(2,444); // 인덱스 , 변경할 것
        // 위치에 요소 추가
        inst1.add(0,11);

        // 간략한 생성 및 초기화
        LinkedList<Integer> ints2A = new LinkedList<>(
                Arrays.asList(1,2,3,4,5)
        );

        LinkedList<Integer> inst2B = new LinkedList<>(
                List.of(1,2,3,4,5)
        );

        LinkedList<Integer> ints2C = new LinkedList<>();
        Collections.addAll(ints2C, 1, 2, 3, 4, 5);

        //  💡 다른 Collection 인스턴스를 사용하여 생성
        LinkedList<Integer> ints3 = new LinkedList<>(inst1);

        //  스스로를 복제하여 반환 (⚠️ 얕은 복사)
        LinkedList<Integer> ints4 = (LinkedList<Integer>) ints3.clone();


        ints3.remove(4); // 인덱스로 삭제
        ints3.remove((Integer)55); // 요소 중 55를 찾아서 삭제
        // 이유 -(Integer)는 Boxing(포장) 연산으로, 기본 데이터 타입인 int를 Integer 객체로 변환.
        // 따라서 remove((Integer)30)은 리스트에서 값이 30인 첫 번째 요소를 찾아 제거

        inst1.removeAll(ints3); // 주어진 콜렉션에 있는 요소 제거
        inst1.addAll(ints3); // 다 넣어서 붙임

        // toArray - Object 배열 반환
        Object[] intsAry2_Obj = inst1.toArray();
        //  ⭐️ 특정 타입의 배열로 반환하려면?
        //  Integer[] ints1Ary1 = (Integer[]) ints1.toArray(); // ⚠️ 이렇게는 불가
        //  💡 인자로 해당 타입 배열의 생성자를 넣어줌
        //  - 다음 섹션에 배울 메소드 참조 사용 (9-3강 수강 후 다시 볼 것)
        Integer[] ints1Ary2 = inst1.toArray(Integer[]::new);

        // 리스트 비우기
        inst1.clear();


        //  제네릭 적용
        numbers.add(Integer.valueOf(123));
        numbers.add(3.14);
//        numbers.add("Hello"); // ⚠️ 불가

//        knights.add(new Swordman(Side.BLUE)); // ⚠️ 불가
        knights.add(new Knight(Side.BLUE));
        knights.add(new MagicKnight(Side.RED));

        //  와일드카드 적용
        //  기사 이상의 그룹으로만 편성될 수 있는 정예분대
        LinkedList<? extends Knight> eliteSquad; // Knight의 자손

//        eliteSquad = new LinkedList<Swordman>(); // ⚠️ 불가
        eliteSquad = new LinkedList<Knight>();
        eliteSquad = new LinkedList<MagicKnight>();

        //  ⭐️ 인스턴스 요소를 지울 때는 참조를 기준으로
        //  - 내용이 같다고 같은 인스턴스가 아님
        Knight knight1 = new Knight(Side.RED);
        knights.add(knight1);

        //  요소가 하나 지워졌는지 여부 반환
        boolean removed1 = knights.remove(new Knight(Side.RED));
        boolean removed2 = knights.remove(knight1);
    }
}
