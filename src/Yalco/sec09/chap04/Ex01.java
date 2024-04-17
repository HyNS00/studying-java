package Yalco.sec09.chap04;
import java.util.*;
import java.util.stream.Collectors;
public class Ex01 {
    public static void main(String[] args) {
        List<Integer> int0To9 = new ArrayList<>(
                Arrays.asList(1,2,3,4,5,6,7,8,9)
                );
        // int0To9에서 홀수만을 골라내는 방식

        // 기존 방식
        List<Integer> odds = new ArrayList<>();
        for (Integer i : int0To9){
            if (i % 2 == 1){
                odds.add(i);
            }
        }
        odds.sort(Integer::compare); // Collections.sort(odds);
        List<String> oddsStrs = new ArrayList<>();
        for (Integer i : odds){
            oddsStrs.add(String.valueOf(i));
        }
        String oddsStr =String.join(", ", oddsStrs);
        System.out.println(oddsStr);

        // 스트림을 활용
        String oddsStrStreamed = int0To9
                .stream()
                .filter(i -> i % 2 == 1)
                .sorted(Integer :: compare)
                .map(String :: valueOf)
                .collect(Collectors.joining(", "));
    }
}
