package Yalco.sec08.chap02;

import java.util.*;
import Yalco.sec07.chap04.*;
public class Main_Map {
    public static void main(String[] args) {
        // Map<Key, Value>
        Map<Integer,String> numNameHMap = new HashMap<>();

        // .put 메소드 -> 키와 값을 삽입한다.
        numNameHMap.put(1,"홍길동");
        numNameHMap.put(2,"전우치");
        numNameHMap.put(3,"김현수");

        Map<String, Double> nameHeightHMap = new HashMap<>();
        nameHeightHMap.put("김철수", 176.8);
        nameHeightHMap.put("이장신", 187.4);
        nameHeightHMap.put("박숏달", 152.3);
        nameHeightHMap.put("정기준", 171.2);

        Map<Side,ArrayList<Unit>> sideUnitsHMap = new HashMap<>();
        sideUnitsHMap.put(Side.RED,
                new ArrayList<>(Arrays.asList(
                        new Knight(Side.RED),
                        new Knight(Side.RED),
                        new Knight(Side.RED)
                )));


        // putAll -대상 맵으로부터 전부 가져온다
        Map<Integer, String> numNameHMapClone = new HashMap<>();
        numNameHMapClone.putAll(numNameHMap);


        // .get() -> key를 넣어 value에 접근
        String no2 = numNameHMap.get(2);
        Double height = nameHeightHMap.get("이장신");

        // 잘못된 key값을 넣을시 null반환 , 오류는 발생하지 않으니 주의
        String wrong1 = numNameHMap.get(0);
        Double wrong2 = nameHeightHMap.get(3);

        // keySet -> 키들의 Set반환
        Set<Integer> numSet = numNameHMap.keySet();
        Set<Integer> numHSet = new HashSet<>();
        numHSet.addAll(numSet);

        // for each문 ,.keySet()을 사용한 이후부터 이미 set
        for(Integer n : numNameHMap.keySet()){
            System.out.println(numNameHMap.get(n));
        }

        for (Side side : sideUnitsHMap.keySet()){
            System.out.println(side);;
        }

        // containsKey, containsValue : 키/값 포함되는 쌍이 있는지 확인
        boolean contains1 = nameHeightHMap.containsKey("박숏달");
        boolean contains2 = nameHeightHMap.containsKey("장롱");
        boolean contains3 = nameHeightHMap.containsValue(172.2);

        System.out.printf("\n- - - - -\n");

        Map<Attacker, Horse> atkrHrsHMap = new HashMap<>();

        Swordman kenshin  = new Swordman(Side.RED);
        Knight lancelot = new Knight(Side.RED);

        atkrHrsHMap.put(kenshin,new Horse(40));
        atkrHrsHMap.put(lancelot, new Horse(50));
        atkrHrsHMap.put(new MagicKnight(Side.BLUE), new Horse(60));

        // 키의 값이 참조형일 경우에는 변수에 저장되어있어야한다.
        Horse kenshinHorse = atkrHrsHMap.get(kenshin);
        Horse lancelotHorse = atkrHrsHMap.get(lancelot);
        //  ⚠️ 일반적인 방법으로는 꺼낼 수 없음
        Horse wrongHorse = atkrHrsHMap.get(new MagicKnight(Side.BLUE));
        // 다른 객체임으로

        // 꺼내는 방법
        for (Attacker attacker : atkrHrsHMap.keySet()){
            System.out.println(attacker + " : " + atkrHrsHMap.get(attacker));
        }

        // getOrDefault -> 키에 해당하는 쌍이 없을 시 지정한 디폴트 값을 반환
        String defName = numNameHMap.getOrDefault(10,"김태타");
        // 만약 numNameHMap에 key10에 대응하는 value가 있다면 값을 반환해서 defName, 없다면 김대타
        Horse defHorse = atkrHrsHMap.getOrDefault(new MagicKnight(Side.BLUE), new Horse<>(40));

        // Entry 인터페이스 -> 맵의 각 요소, 키와 값을 가진다.
        Set<Map.Entry<Integer, String>> numNameES = numNameHMap.entrySet();
        for( Map.Entry<Integer,String> entry : numNameES){
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("k: %d, v: %s%n", key, value);
            System.out.println(entry);
        }


        // isEmpty, clear, remove
        numNameHMap.remove(1); // 주어진 키가 존재한다면 삭제하고 value값을 반환
        numNameHMap.remove(2,"황대장"); // 주어진 키와 값이 존재한다면 삭제
        // . remove 메소드는 주어진 키와 값이 맵에 정확하게 일치할 때에만 매핑을 제거합니다.
        // ⚠️
        //따라서 numNameHMap.remove(2, "황대장")는 키 2에 해당하는 값이 "황대장"인 경우에만 매핑을 제거하고,
        // 그 외의 경우에는 아무 동작도 수행하지 않습니다. 만약 키가 존재하지 않거나 값이 일치하지 않으면 맵은 변경되지 않습니다.


        // 트리맵
        // 해시맵 - 키와 값
        // 트리맵 - 키를 트리 형태로 저장
        // 따라서 정렬과 무관할시엔 해시맵이 더 빠르고 , 키순으로 정렬이 필요한 경우엔 트리맵
        TreeMap<Integer, String[]> classKidsTMap = new TreeMap<>();
        classKidsTMap.put(3, new String[] {"서아", "이준","아린"});
        classKidsTMap.put(9, new String[] {"하윤", "서준", "지호"});
        classKidsTMap.put(1, new String[] {"이서", "하준", "아윤"});
        classKidsTMap.put(7, new String[] {"지안", "은우", "예준"});
        classKidsTMap.put(5, new String[] {"서윤", "시우", "하은"});

        // 트리 전용 메소드
        int firstKey = classKidsTMap.firstKey();
        int lastKey = classKidsTMap.lastKey();

        Map.Entry<Integer, String[]> firstEntry = classKidsTMap.firstEntry();
        Map.Entry<Integer, String[]> lastEntry = classKidsTMap.lastEntry();

        int ceil4 = classKidsTMap.ceilingKey(4);
        Map.Entry<Integer, String[]> floor4 = classKidsTMap.floorEntry(4);

        // pollFirstEntry -> 가장 작은 키값의 엔트리를 제거하고 제거한 값을 pollF1에 저장, TreeMap변경
        // pollLastEntry -> 가장 큰 키값의 엔트리를 제거하고 제거한 값을 pollL1에 저장
        Map.Entry<Integer, String[]> pollF1 = classKidsTMap.pollFirstEntry();
        Map.Entry<Integer, String[]> pollF2 = classKidsTMap.pollFirstEntry();
        Map.Entry<Integer, String[]> pollL1 = classKidsTMap.pollLastEntry();
        Map.Entry<Integer, String[]> pollL2 = classKidsTMap.pollLastEntry();
    }

}