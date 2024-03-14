package sec08.chap03.ex02;

import java.util.Comparator;

public class IntDescComp implements Comparator<Integer> {
    @Override
    // 원래는 오름차순으로 정리하는 것을 Override를 통해 내림차순으로 변경

    public int compare(Integer o1, Integer o2){
        return o2 - o1;
    }
}
