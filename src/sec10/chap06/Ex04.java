package sec10.chap06;


import sec09.chap05.ex02.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.*;
public class Ex04 {
    public static void main(String[] args) {
        var numFromOpt = IntStream.range(0,100)
                .filter(i -> i % 2 == 1)
                //.filter(i -> i > 100)

                .findFirst() // 첫번 째 요소를 반환
                //.max()
                //.min()
                // 평균값을 Double로 반환
                //.average()
                //.reduce((prev,curr) ->prev + curr)
                .orElse(1);

        String[] names = {
                "강백호", "서태웅", "채치수", "송태섭", "정대만",
                "윤대협", "변덕규", "황태산", "안영수", "허태환",
                "이정환", "전호장", "신준섭", "고민구", "홍익현",
                "정우성", "신현철", "이명헌", "최동오", "정성구"
        };

        Stream<String> nameStream = Arrays.stream(names);

        Random random = new Random();
        random.setSeed(4); // 균일한 결과를 위해 지정된 시드값
        List<Person> people = nameStream
                .map(name -> new Person(
                        name,
                        random.nextInt(18, 35),
                        random.nextDouble(160, 190),
                        random.nextBoolean()
                ))
                .sorted()
                .toList();

        Person personFromOpt = people.stream()
                //.filter(p -> !p.isMarried() && p.getAge() < 20 && p.getHeight() > 189)

                .findFirst()

                //.max(Comparator.comparingDouble(Person::getHeight))
                //.min(Comparator.comparingInt(Person::getAge))

                .orElse(new Person("엄친아", 19, 189.9, false));
    }
}
