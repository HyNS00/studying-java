package Yalco.sec09.chap05.ex02;
import java.util.stream.*;
import java.util.*;

public class Ex02 {
    public static void main(String[] args) {
        String[] names = {
                "강백호", "서태웅", "채치수", "송태섭", "정대만",
                "윤대협", "변덕규", "황태산", "안영수", "허태환",
                "이정환", "전호장", "신준섭", "고민구 ", "홍익현",
                "정우성", "신현철", "이명헌", "최동오", "정성구"
        };

        Stream<String> nameStream = Arrays.stream(names);
        Random random = new Random();
        random.setSeed(4);

        List<Person> people = nameStream
                .map(name -> new Person(
                        name,
                        random.nextInt(18,35),
                        random.nextDouble(160, 180),
                        random.nextBoolean()
                ))
//                .sorted()
                .sorted((s1,s2) -> s1.getHeight() > s2.getHeight() ? 1 : -1) //키순으로 sort
                .toList();

        // collect, Collectors의 기능들
        var peopleLastNameSet = people.stream()
                .map(p -> p.getName().charAt(0)) // 성을 기준으로
//                .collect(Collectors.toList());
                .collect(Collectors.toCollection(ArrayList :: new));

        Map<String,Integer> nameAgeMap = people.stream()
                .sorted((p1,p2) -> p1.getAge() > p2.getAge() ? 1 : -1) // map은 sort기능이 없다
                .collect(Collectors.toMap(Person::getName, Person::getAge));

        Map<Boolean,List<Person>> peopleHMapByMarried = people.stream()
                .collect(Collectors.groupingBy(Person :: isMarried)); // isMarried를 기준으로분류
        List<Person> marrieds = peopleHMapByMarried.get(true);

        Map<Integer,List<Person>> peopleHMapByHeight = people.stream()
                .collect(Collectors.groupingBy(
                        p -> ((int) p.getHeight()/ 10) * 10
                ));
        List<Person> over180s = peopleHMapByHeight.get(180);


        Map<Character, List<Integer>> intHMapByOddEven = IntStream.range(0,10).boxed().collect(Collectors.groupingBy(
                i -> i % 2 == 1 ? '홀' : '짝'));
        List<Integer> odds = intHMapByOddEven.get('홀');

        // 수의 통계를 인스턴스로 가지는 클래스
        IntSummaryStatistics ageStats = people.stream()
                .map(Person :: getAge)
                .collect(Collectors.summarizingInt(Integer :: intValue));
        DoubleSummaryStatistics heightStats = people.stream()
                .map(Person::getHeight)
                .collect(Collectors.summarizingDouble(Double::doubleValue));
    }

}
