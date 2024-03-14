package sec08.chap03.ex02;

import java.util.*;
import sec07.chap04.*;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {3,8,7,1,4,9,2,6,5};
        String [] strs = {
                "Fox","Banana", "Elephant", "Car", "Apple", "Game", "Dice"
        };

        IntDescComp intDescComp = new IntDescComp(); // 클래스로 설정했으니 객체를 생성해줘야한다
        Arrays.sort(nums, intDescComp);  // 내림차순 정렬


        Arrays.sort(nums, new CloseToInt(5)); // 5와 인접한 숫자
        // 익명클래스
        Arrays.sort(strs, new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                return o1.length() - o2.length();
            }
        }); // new Comparator<String>인 익명 클래스 생성

        // ArrayList도 sort 메소드가 가능
        ArrayList<Integer> numsAry =  new ArrayList<>(Arrays.asList(nums));
        numsAry.sort(new IntDescComp());

        numsAry.sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return (o1 % 2) - (o2 % 2); // 짝수가 앞으로 오게 설정 ( 익명 클래스)
            }
        });

        // TreeSet에 써보기
        TreeSet<Unit> unitTSet = new TreeSet<>(new UnitSorter());
        for (Unit u : new Unit[] {
                new Knight(Side.BLUE),
                new Knight(Side.BLUE), // 중복
                new Swordman(Side.RED),
                new Swordman(Side.RED), // 중복
                new MagicKnight(Side.BLUE),
                new Swordman(Side.BLUE),
                new MagicKnight(Side.RED),
                new Knight(Side.RED)
        }) {
            unitTSet.add(u);
        }
    }
}
