package Yalco.sec09.chap04;

import Yalco.sec07.chap04.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.*;
import java.util.*;
public class Ex02 {
    public static void main(String[] args) {
        // 스트림 예제
        Integer[] integerArys = {1,2,3,4,5}; // 배열 생성
        Stream<Integer> fromArray = Arrays.stream(integerArys); // stream으로 변경
        Object[] fromArray_Arr = fromArray.toArray(); // 스트림을 다시 배열로 반환

        // 원시값의 배열로부터는 스트림의 클래스가 달라진다.
        int[] intAry ={1,2,3,4,5};
        IntStream fromIntAry = Arrays.stream(intAry);
        int[] fromIntAry_Arr = fromIntAry.toArray();

        double[] dblAry = {1.2,2.3,4.4};
        DoubleStream fromDblAry = Arrays.stream(dblAry);
        double[] fromDblAry_Arr = fromDblAry.toArray();

        // 값들로 진적 생성
        IntStream withInts = IntStream.of(1,2,3,4,5);
        Stream<Integer> withIntegers = Stream.of(1,2,3,4,5,6);
        Stream<Unit> withUnits = Stream.of(
                new Knight(Side.RED),
                new Swordman(Side.BLUE),
                new MagicKnight(Side.RED)
        );
        Object[] withUnits_Arr = withUnits.toArray();

        // 컬렉션으로부터 생성
        List<Integer> intAryList = new ArrayList<>(Arrays.asList(integerArys));
        Stream fromColl1 = intAryList.stream();
        Object[] fromColl1_Ary= fromColl1.toArray();

        // 맵 -> 엔트리의 스트림으로 생성
        Map<String,Character> subjectGradeHM = new HashMap<>();
        subjectGradeHM.put("english",'B');
        subjectGradeHM.put("Math",'C');
        subjectGradeHM.put("Programming",'A');
        Object[] fromHashMap_Arr = subjectGradeHM.entrySet().toArray();

        // 빌더로 생성
        Stream.Builder<Character> builder = Stream.builder();
        builder.accept('스');
        builder.accept('트');
        builder.accept('림');
        Stream<Character> withBuilder = builder.build();
        Object[] withBuilder_Arr = withBuilder.toArray();

        // concat메소드 활용
        Stream<Integer> toConcat1 = Stream.of(11,22,33);
        Stream<Integer> toConcat2 = Stream.of(44,55,66);
        Stream<Integer> withConcatMethod = Stream.concat(toConcat1,toConcat2);
        Object[]  withConcatMethod_Arr = withConcatMethod.toArray();

        // 이터레이터로 생성 및 활용
        // 인자 -> 초기값 설정, 다음 값을 구하는 람다함수
        // limit -> 횟수를 지정해야한다.
        Stream<Integer> withIter1 = Stream
                .iterate(0,i -> i+2)
                .limit(10); //
        Object[] withIter1_Arr = withIter1.toArray();

        Stream<String> withIter2 = Stream
                .iterate("홀", s ->  s+ (s.endsWith("홀") ? "짝" : "홀"))
                .limit(8);

        // "홀" 는 seed를 의미한다.
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        // UnaryOperator에서 s -> s.endsWith()을 해줌으로써 마지막 자리가 홀이라면 짝으로, 아니라면 홀으로 변경
        // 8번 반복 -> 인덱스 7

        Object[] withIter2_Arr = withIter2.toArray();

        // 원시자료형 스트림의 기능들로 구성
        IntStream fromRange1 = IntStream.range(10,20); // 일반적인 range 10 ~19
        IntStream fromRange2 = IntStream.rangeClosed(10,20); // 마지막요소까지 포함, 10 ~ 20
        Stream<Integer> fromRangeBox = fromRange1.boxed(); // IntStream의 래퍼 클래스
        Object[] fromRangeBox_Arr = fromRangeBox.toArray();

        //  💡 Random 클래스의 스트림 생성 메소드들
        IntStream randomInts = new Random().ints(5, 0, 100);
        int[] randomInts_Arr = randomInts.toArray();

        DoubleStream randomDbls = new Random().doubles(5, 2, 3);
        double[] randomDbls_Arr = randomDbls.toArray();

        // 파일로부터 생성
        // File I/O
        Stream<String> fromFile;
        Path path = Paths.get("./src/Yalco.sec09/chap04/sample.txt");
        try{
            fromFile = Files.lines(path);
        } catch(IOException e){
            throw new RuntimeException(e);
        }

        Object[] fromFile_Arr = fromFile.toArray();

        //  💡 빈 스트림 생성
        //  - 스트림을 받는 메소드 등에서 종종 사용
        Stream<Double> emptyDblStream = Stream.empty();
    }
}
