package sec08.chap02;

import java.util.*;

import sec07.chap04.*;

public class Main_Set {
    public static void main(String[] args) {
        Set<Integer> intHSet1 = new HashSet<>();
        intHSet1.add(1);
        intHSet1.add(1);
        intHSet1.add(2);
        intHSet1.add(3);

        List<Integer> ints1 = new ArrayList<>(
                Arrays.asList(1,1,2,2,3,3,4,4,5,6)
        );

        Set<Integer> intHSet2 = new HashSet<>();
        // for each문 가능
        for (Integer i : intHSet1){
            System.out.println(i);
        }

        //  ⭐️ 아래와 같이 응용 가능
        //  - 중복을 제거한 ArrayList
        ints1.clear();
        ints1.addAll(intHSet2);

        // 해쉬 셋의 메소드
        boolean has2 = intHSet1.contains(2); // 포함여부
        boolean has3 = intHSet1.contains(4);

        // 요소를 삭제 + 있었는지 여부 반환
        boolean rm3 = intHSet1.remove(3);
        boolean rm4 = intHSet1.remove(4);

        // 다른 콜렉션을 기준으로 내용을 삭제
        intHSet2.removeAll(intHSet1); // intHSet1의 내용을 전부 삭제

        Set<Swordman> swordmenSet = new HashSet<>();
        Swordman swordman = new Swordman(Side.RED);

        swordmenSet.add(swordman);
        swordmenSet.add(swordman);
        // swordman은 중복
        swordmenSet.add(new Swordman(Side.RED)); // 이 2개는 다른 객체이므로 Set에 따로 들어간다.
        swordmenSet.add(new Swordman(Side.RED));

        HashSet<Integer> intHashSet = new HashSet<>();
        LinkedHashSet<Integer> intLinkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> intTreeSet = new TreeSet<>();

        for (int i : new int[] { 3, 1, 8, 5, 4, 7, 2, 9, 6}){
            intHashSet.add(i);
            intLinkedHashSet.add(i);
            intTreeSet.add(i);
        }
        for (Set s : new Set[] {intHashSet, intLinkedHashSet, intTreeSet}){
            System.out.println(s);
        }
        // 각 set의 자료형을 알 수 있다.
        // HashSet은 얼핏 정렬된 상태로 들어간 것을 볼 수 있다(아마 크기가 더 커진다면 깨질 것 - 보장아님)
        // LinkedHashSet 은 입력해서 들어간 순서대로 들어가 있는 것을 확인할 수 있다.
        // TreeSet은 정렬이 된 상태로 들어가 있음을 확인할 수 있다.(오름차순)

        Set<String> strHashSet = new HashSet<>();
        Set<String> strLinkedHashSet = new LinkedHashSet<>();
        TreeSet<String> strTreeSet = new TreeSet<>();

        for (String s : new String[] {
                "Fox", "Banana", "Elephant", "Car", "Apple", "Game", "Dice"
        }) {
            strHashSet.add(s); //문자열 정렬은 순서정렬이 안됨
            strLinkedHashSet.add(s);
            strTreeSet.add(s);
        }
        for (Set s : new Set[] {strHashSet, strLinkedHashSet, strTreeSet}) {
            System.out.println(s);
        }

        //  💡 TreeSet의 주요 메소드들
        int firstInt = intTreeSet.first();
        String lastStr = strTreeSet.last(); // TreeSet으로 바꾸자
        //  같은 것이 없다면 트리구조상 바로 위의 것 (바로 더 큰 것) 반환
        String foxCeiling = strTreeSet.ceiling("Fox");
        String creamCeiling = strTreeSet.ceiling("Cream");

        //  같은 것이 없다면 트리구조상 바로 아래의 것 (바로 더 작은 것) 반환
        String foxFloor = strTreeSet.floor("Fox");
        String diceFloor = strTreeSet.floor("Cream");

        //  맨 앞에서/뒤에서 제거

        int pollFirst1 = intTreeSet.pollFirst();
        int pollFirst2 = intTreeSet.pollFirst();

        int pollLast1 = intTreeSet.pollLast();
        int pollLast2 = intTreeSet.pollLast();


        // TreeSet 뒤집기
        Set<String> strTreeSetDesc
                = (TreeSet<String>) strTreeSet.descendingSet(); // 형변환 필요 -NavigableSet<E>


        //  ⚠️ 요소로 추가 불가
        //  - 이후 배울 Comparable 또는 Comparator 필요
        TreeSet<Knight> knightSet1 = new TreeSet<>(); // 정렬 기준이 모호하기 때문 ( 숫자 -> 크기비교, 글자 -> 사전 순)
        knightSet1.add(new Knight(Side.BLUE));
        knightSet1.add(new Knight(Side.BLUE));
        knightSet1.add(new Knight(Side.BLUE));
    }
}
