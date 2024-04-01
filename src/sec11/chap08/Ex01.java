package sec11.chap08;


import java.util.*;
import java.util.stream.Stream;

public class Ex01 {
    public static void main(String[] args) {
        // 🤓병렬스트림 -> filter,map,reduce은 병렬 스트림으로 처리가 가능
        // 🤓성능향상을 웬만하면 기대할 수 있다 but 데이터 크기 작을 경우에는 성능 저하 가능성 잇음

        Stream<Character> stream1 = Stream.of('A', 'B', 'C');

        // isParallel : 스트림이 병렬인지 여부
        boolean bool1 = stream1.isParallel(); // 🤓 처음 생성시 단일

        // parallel : 스트림을 병렬로 바꿈
        stream1.parallel();

        //  💡 sequential : 병렬 스트림을 직렬로 바꿈
        stream1.sequential();
        boolean bool3 = stream1.isParallel();

        // 처음부터 병렬 스트림으로 생성
        //  - Arrays와 Collection의 parallelStream 사용
        Stream<Integer> stream2 = Arrays.asList(1,2,3,4,5).parallelStream();

        List<Double> dblList = new ArrayList<>(Arrays.asList(1.23,3.45,3.55));

        // 🤓 List<Double> dblList = Arrays.asList(...); 이렇게 작성했다면, 고정된 크기의 리스트가 생성된다.
        // new ArrayList<>()를 해줬기 때문에 수정가능한 리스트 생성

        Stream<Double> stream3 = dblList.parallelStream();


    }

}
