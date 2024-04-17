package Yalco.sec09.chap05;

import java.util.*;
import java.util.stream.*;

public class Ex01 {
    public static void main(String[] args) {
        IntStream
                .range(0,100)
//                .filter(i -> i %2 == 0)
                .skip(10)  // n개 만큼 건너뜀
//                .limit(10)
//                .map(i -> i * 10)
                .forEach(System.out :: println);

        System.out.println("\n- - - - -\n");

        String str1 = "Hello World! Welcome to the world of Java~";
        str1.chars().forEach(System.out::println);
        // .chars() -> 해당하는 문자를 아스키 코드로 변환해줌
        // collection.forEach(변수 -> 반복처리(변수))
        System.out.println("\n- - - - -\n");

        char str1MaxChar = (char) str1.chars()
                .max()
                .getAsInt(); // OptionalInt 반환값이 없을 때의 예외를 생각해서 만듦

        str1.chars()
                .sorted()
                .distinct() // 중복제거
                .filter(i -> (i >= 'A' && i <= 'Z') || (i >='a' && i <= 'z'))
                .forEach(i -> System.out.println((char)i));

        System.out.println("\n- - - - -\n");
        //  대소문자 구분 없이 중복 제거한 뒤 정렬하고 쉼표로 구분
        String fromStr1 = str1.chars().boxed()
        // 💡 boxed를 사용하여 Stream<Integer>으로 변환
        //  요소를 다른 타입으로 바꾸려면 Stream<T>을 사용해야 함
                .map(i -> String.valueOf((char) i.intValue()))
                .map(String :: toUpperCase)
                .filter(s -> Character.isLetter(s.charAt(0))) // 빈칸들 제거
                .sorted()
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("\n- - - - -\n");
        // peek으로 중간과정 체크
        // 디버깅시 유용
        String oddSquaresR = IntStream.range(0,10).boxed()
                .peek(i -> System.out.println("초기값" + i))
                .filter(i -> i % 2 == 1)
                .peek(i -> System.out.println("홀수만" + i))
                .map(i -> i*i)
                .peek(i -> System.out.println("제곱" + i))
                .sorted((i1, i2) -> i1 < i2 ? 1 : -1)
                .peek(i -> System.out.println("역순" + i))
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        Integer[] ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // allMatch / anyMatch  :모든 요소/ 어느 요소 라도
        boolean intsMatch = Arrays.stream(ints)
//                .allMatch(i -> i > 0)
//                .allMatch(i -> i % 2 == 0);
                  .anyMatch(i -> i < 0);
        //.anyMatch(i -> i % 2 == 0);

        System.out.println("\n ----------\n");
        // takeWhile/ dropWhile -> 주어진 것을 만족할 때까지 가져감(take) 또는 건너뜀(drop)
        // count : 중간과정을 거친 요소들의 개수를 반환

        long afterWhileOp = Arrays.stream(ints)
//                .takeWhile(i -> i < 4)
                .dropWhile(i -> i < 4)
                .peek(System.out :: println)
                .count();

        //  💡 sum : IntStream, LongStream, DoubleStream 요소의 총합 반환

        int intsSum = IntStream.range(0, 100 + 1)
                .limit(10)
                //.filter(i -> i % 2 == 1)
                //.filter(i -> i % 2 == 0)
                //.filter(i -> i % 3 == 0)
                .sum();

        System.out.println("\n- - - - -\n");

        double doubleSum = DoubleStream.iterate(3.14, i -> i * 2)
                .limit(10)
                .peek(System.out::println)
                .sum();

        System.out.println("\n- - - - -\n");
        // reduce : 주어진 BiFunction으로 값을 접어나감
        // seed값이 없을 때 : Optional 반환 -> 빈 스트림일 수 있기 때문
        int intReduce = IntStream.range(1,10)
                .reduce((prev, curr) -> {
                    System.out.printf("prev : %d, curr : %d", prev, curr);
                    return prev * curr;
                })
                // reduce -> 순서대로 리그라고 생각하면 편함
                //  연산의 결과를 계속해서 누적하는 역할
                .getAsInt();
        // 초기값, 즉 seed가 존재할 경우
        int intReduceWithSeed = IntStream.range(1,10)
                .reduce(2,(prev, curr) ->
                        prev * curr); // 시드가 있으므로 reduce값이 없을 때는 seed를 반환

        StringStat stringStat = "Hello World! Welcome to the world of Java~"
                .chars()
                .boxed()
                .reduce(
                        new StringStat(),
                        (ss, i) -> {
                            ss.length++;
                            if (i >= 'A' && i <= 'Z') { ss.upperCases++; }
                            else if (i >= 'a' && i <= 'z') { ss.lowerCases++; }
                            else { ss.nonLetters++; }
                            return ss;
                        },
                        (ss1, ss2) -> ss1
                );
    }
    public static class StringStat{
        int length = 0;
        int upperCases = 0;
        int lowerCases = 0;
        int nonLetters = 0;
    }
}
