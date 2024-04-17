package Yalco.sec08.chap03.ex01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer int1 = Integer.valueOf(1);
        Integer int2 = Integer.valueOf(2);
        Integer int3 = Integer.valueOf(3);

        // 대상과 비교했을 때 작으면 -1 , 같다면 0, 크다면 1 반환
        // compareTo의 메소드 형식을 비교하면 쉽다 -> override 할 수 있다

        int a = int1.compareTo(3);
        int b = int2.compareTo(1);

        int c = int3.compareTo(3);

        int tfcomp = Boolean.valueOf(true).compareTo(Boolean.valueOf(false));
        int strcomp = "ABC".compareTo("DEF");
        int strcomp_2 = "def".compareTo("abc");

        Integer[] nums = {3,8,7,1,4,9,2,6,5};
        String [] strs = {
             "Fox","Banana", "Elephant", "Car", "Apple", "Game", "Dice"
        };

        // Arrays 클래스의 sort메소드
        // 기본적으로 compareTo에 의해 정렬된다 .
        // 따라서 일반 자료형이 아닌 클래스 자료형의 경우 @Override하지 않아서 기준이 없어 정렬되지 않는다.
        Arrays.sort(nums); // 숫자는 대소관계에 의해
        Arrays.sort(strs); // 단어는 사전순

    }

}
