package Yalco.sec10.chap06;

import Yalco.sec07.chap04.*;
import java.util.*;
import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        List<Optional<Unit>> randomUnitOpts = new ArrayList<>();
        IntStream.range(0,20)
                .forEach(i -> randomUnitOpts.add(randomUnitOpt()));

        randomUnitOpts.stream()
                .forEach(opt -> System.out.println(
//                        opt.isPresent() // 있다면 true
//                        opt.isEmpty() // 비어있다면 true
//                          opt.get() // 있다면 반환, 없다면 npe
                          opt.orElse(new Swordman(Side.RED)) // 비어있을시 기본값으로 제공, 함수를 제공하는 것도 있다.
                ));

        System.out.println("\n- - - - -\n");
        randomUnitOpts.stream()
                .forEach(opt -> {
                    //  있다면 때 실행할 Consumer
                    opt.ifPresent(unit -> System.out.println(unit));

                    //  있다면 실행할 Consumer, 없다면 실행할 Runner(없으므로)
                    //opt.ifPresentOrElse(
                    //        unit -> System.out.println(unit),
                    //        () -> System.out.println("(유닛 없음)")
                    //);
                });

        System.out.println("\n- - - - -\n");

        List<Optional<Integer>> optInts = new ArrayList<>();
        IntStream.range(0,20)
                .forEach(i -> {
                    optInts.add(Optional.ofNullable(
                            new Random().nextBoolean() ? i : null
                    ));
                });

        optInts.stream()
                .forEach(opt -> {
                    System.out.println(
                            opt
                                    //  ⭐️ 걸러진 것은 null로 인식됨
                                    //  - 스트림의 filter처럼 건너뛰는 것이 아님!
                                    .filter(i -> i % 2 == 1)
                                    .map(i -> "%d 출력".formatted(i))
                                    .orElse("(SKIP)")
                    );
                });
    }
    public static Optional<Unit> randomUnitOpt() {
        switch(new Random().nextInt(0,3)){
            // 각각 return이 존재하기에 break가 필요없다
            case 0: return Optional.of(new Knight(Side.BLUE));
            case 1 : return Optional.of(new MagicKnight(Side.BLUE));

            default : return Optional.empty(); // null을 반환하는 메소드 -> 일반 null을 할시 npe발생

        }
    }
}
