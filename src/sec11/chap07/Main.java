package sec11.chap07;

import sec07.chap04.*;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try {
            //  여기서 아래의 메소드들을 하나씩 호출할 것
            //🤓  각 메소드 호출은 개별적으로 try-catch 블록으로 감싸야 하며,
            // 예외가 발생한 경우에는 해당 예외를 처리할 수 있습니다.
//            supplyAsyncEx();
//            thenAcceptEx1();
//            thenAccept2();
//            thenApplyEx2();
//            exceptionallEx(false);
//            exceptionallEx(true);
//            allOfEx1();
            allOfEx2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void takeTime(boolean error){
        try{
            int randMilliSec = new Random().nextInt(1000,1500);
            Thread.sleep(randMilliSec);
            System.out.printf("... %f 초 경과 ...%n", randMilliSec / 1000.0);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        if(error) {
            throw new RuntimeException("오류 발생");
        }
    }
    public static void supplyAsyncEx() throws ExecutionException, InterruptedException{
        // supplyAsyncEx : Supplier를 받아 비동기적 작업 실행
        CompletableFuture<String> getHello = CompletableFuture.supplyAsync(() -> {
            takeTime(false);
            return "Hello";
            //public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
        });

        System.out.println("- - - get 사용 전 - - -");
        // Future처럼 get을 사용하면 블록킹 발생
        // 값을 받아올 때까지 다음 코드의 진행을 막음 (비동기가 아니게 됨)
        String hello = getHello.get();
        System.out.println("- - - get 사용 후 - - -");
        System.out.println(hello);

    }

    public static void thenAcceptEx1() throws ExecutionException, InterruptedException{
        CompletableFuture<String> getHello = CompletableFuture.supplyAsync(() -> {
            System.out.println("값 받아오기 시작");
            takeTime(false);
            return "Hello";
        }); // 🤓HS :여기까지는 비동기적

        // thenAccept : 받아온 값을 Consumer로 실행(Consumer는 반환값은 없고 매개값은 존재)
        // 이전 값으로부터 얻은 값으로 할 일을 지정(비동기)
        // 지정하기만 할뿐이지 호출은 get을 통함 (동기)
        // get으로 호출을 해도 결국은 supplyAsync의 작업이 끝나고 나서 실행
        CompletableFuture<Void> printHello = getHello.thenAccept(s ->{
            System.out.println("받아온 값 처리 시작");
            takeTime(false);
            System.out.println(s);
                }); // 🤓HS : getHello가 완료될 때까지 있다가 값을 받아 비동기적으로 동작
                // 완전히 동작하는게 아니라 동작 대기를 하는 것

        System.out.println("- - - 중간에 다른 코드들 진행 - - -");
        printHello.get();
        // 🤓 그러나 .get()을 받은 후 동작을 완료함(동기적)
        // 🤓 비동기적이엇다면 printHello가 동작을 마친 후 바로 출력

    }
    public static void thenAccept2() throws ExecutionException, InterruptedException {
        // 비동기 메소드 체이닝
        // 🤓처음 thenAccept1과 다를바 없다 그저 변수 설정을 안해줬을 뿐
        // 🤓왜 <Void>이냐면 위의 thenAccept1의 printHello처럼 Consumer로 반환하는 것이 없기 때문
        // printHello와 getHello를 합쳤다고 생각하면 편하다.
        CompletableFuture<Void> print5nums = CompletableFuture.supplyAsync(() -> {
            List<Integer> ints = new ArrayList<>();
            IntStream.range(0,5).forEach(i  -> {
                takeTime(false);
                ints.add(i);
            });
            return ints;
        }).thenAccept(list -> {
            takeTime(false);
            list.stream().forEach(System.out :: println);
        });
        System.out.println("- - - 중간에 다른 코드들 진행 - - -");

        print5nums.get();
    }

    public static void thenApplyEx1() throws ExecutionException,InterruptedException{
        CompletableFuture.supplyAsync(() ->{
            takeTime(false);
            return new Random().nextInt(0,6) +1;
        }).thenApply(
                //  💡 thenApply : 얻어온 값을 Function에 넣어 다른 값 반환
                //  - 스트림의 map과 비슷
                i -> {
                    takeTime(false);
                    return "이번 숫자" + i;
                }).thenAccept(System.out :: println).get();
    }

    public static void thenApplyEx2() throws ExecutionException,InterruptedException{
            CompletableFuture.supplyAsync(() -> {
                takeTime(false);
                return new Random().nextBoolean(); // 랜덤으로 true false 받아오기
            }).thenApply(b -> {
                takeTime(false); // 값을 받아와서 진영 정하기
                return new Swordman(b ? Side.RED : Side.BLUE);
            }).thenApply(s -> {
                takeTime(false);
                return s.toString(); // 진영에 따른 (BLUE,RED)진영 검사 반환
            }).thenAccept(
                    System.out :: println  // 해당 출력
            ).get();
            // 🤓 Consumer함수로 인해 동작해서 thenAccept를 활용한거지, 굳이 반드시 사용할 필요는 없다
            // thenApply를 적용한 후 .get()을 통해 동기적으로 하는 것 또한 가능하다.
    }

    public static void exceptionallEx(Boolean error) throws ExecutionException,InterruptedException{
        CompletableFuture.supplyAsync(() -> {
            takeTime(error);
            return "반갑습니다";
        }).exceptionally(e -> {
            // exceptionally는 오류 발생시 대체 값 반환
            e.printStackTrace();
            return "잘못된 입력입니다";
        }).thenApply(s -> {
            takeTime(false);
            return "대답 " + s;
        }).thenAccept(
                System.out :: println
        ).get();
    }
    public static CompletableFuture<Swordman> getChamp(Side side){
        return CompletableFuture.supplyAsync(() ->{
            System.out.printf("- - - 🤺 %s 검사 훈련 시작 - - -%n", side.getName());
            takeTime(false);
            return new Swordman(side);
        }).thenApply(c -> {
            System.out.printf("- - - 💪 %s 검사 체력 훈련 - - -%n", side.getName());
            takeTime(false);
            c.hp += new Random().nextInt(0, 3); // 체력 랜덤값을 증가시킴
            return c;
        });
    } // 입력받아서 체력을 랜덤값으로 증가시킨 해당 진영 swordman 출력

    public static void thenComposeEx() throws ExecutionException, InterruptedException{
        CompletableFuture<Swordman> getBlueChamp = getChamp(Side.BLUE);
        CompletableFuture<Swordman> getRedChamp = getChamp(Side.RED);
        System.out.println("\n===== 양 진영 검사 훈련중 =====\n");

        //  💡 thenCompose : 두 CompleteFuture의 결과를 조합
        //  -  ⭐️ 두 작업이 동시에 진행됨 주목
        // 한 CompletableFuture의 결과를 다른 CompletableFuture로 변환하는 작업을 수행할 때 사용
        getBlueChamp.thenCompose(
                b -> getRedChamp.thenApply(
                        r -> {
                            if (b.hp == r.hp) throw new RuntimeException();
                            return b.hp >= r.hp ? b : r;
                            })

                )
                .thenApply(Swordman::toString)
                .thenApply(s -> "🏆 승자 : " + s)
                .exceptionally(e -> "무승부")
                .thenAccept(System.out :: println)
                .get();
        // 🤓단계에서의 결과(saidMessage)를 파라미터로 받으면서, 또 다른 CompletableFuture를 반환하는 Function 인터페이스를 인자로 받습니다
        //출처: https://wbluke.tistory.com/50 [함께 자라기:티스토리]
    }

    public static void thenCombineEx () {
        CompletableFuture<Swordman> getBlueChamp = getChamp(Side.BLUE);
        CompletableFuture<Swordman> getRedChamp = getChamp(Side.RED);

        System.out.println("\n===== 양 진영 검사 훈련중 =====\n");
        try {
            getBlueChamp.thenCombine(
                    getRedChamp, (b,r) -> {
                        if (b.hp == r.hp) throw new RuntimeException();
                        return b.hp >= r.hp ? b : r;
                    }
            ).thenApply(Swordman :: toString)
                    .thenApply(s -> "🏆 승자 : " + s)
                    .exceptionally(e -> "무승부")
                    .thenAccept(System.out :: println)
                    .get();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }catch (ExecutionException e){
            throw new RuntimeException(e);
        }

        //thenCombine은 두 개의 CompletableFuture가 모두 완료되어야만 실행
        // 그래서 이 메서드는 병렬적으로 두 작업을 실행하지 않습니다
    }
    public static CompletableFuture<Integer> rollDiceFuture() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("주사위 굴림");
            takeTime(new Random().nextBoolean());
            int result = new Random().nextInt(0,6) +1;
            System.out.println("🎲 : " + result);
            return result;
        }).exceptionally(e -> -1); // 예외에는 -1
    }

    public static void allOfEx1 () throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> roll1 = rollDiceFuture();
        CompletableFuture<Integer> roll2 = rollDiceFuture();
        CompletableFuture<Integer> roll3 = rollDiceFuture();
        CompletableFuture<Integer> roll4 = rollDiceFuture();
        CompletableFuture<Integer> roll5 = rollDiceFuture();

        //  💡 allOf : 여러 CompletableFuture 작업을 동시에 진행
        //  - thenRun 메소드에서 결과들을 동기적으로 종합
        CompletableFuture.allOf(
                roll1, roll2, roll3, roll4, roll5
        ).thenRun(() -> {
            //  💡 프린트 순서 확인
            System.out.println("✅ 결과 모두 나옴");

            //  ⭐ 각 Future로부터 결과 받아옴
            Integer int1 = roll1.join(); // 블로킹
            Integer int2 = roll2.join();
            Integer int3 = roll3.join();
            Integer int4 = roll4.join();
            Integer int5 = roll5.join();

            String result = IntStream.of(int1, int2, int3, int4, int5)
                    .boxed()
                    .map(i -> i == -1 ? "(무효)" : String.valueOf(i))
                    .collect(Collectors.joining(", "));
            System.out.println("최종 결과 : " + result);
        }).get();
    }

    public static CompletableFuture<Swordman> trainSwordman() {
        return CompletableFuture.supplyAsync(() -> {
            takeTime(new Random().nextBoolean());
            return new Swordman(Side.BLUE);
        }).exceptionally(e -> {
            System.out.println("😭 탈락");
            return null;
        });
    }

    public static void allOfEx2()throws InterruptedException, ExecutionException{
        ArrayList<CompletableFuture<Swordman>> trainings = new ArrayList<>();
        ForkJoinPool forkJoinPool = new ForkJoinPool(3); // 동시 진행 스레드 설정
        //🤓 기존의 15개였는데 3개로 설정해놓으니 확연히 느려짐을 확인할 수 있다.
        for(int i = 0; i < 50; i++){
//            trainings.add(trainSwordman());
             trainings.add(trainSwordmanWithFJP(forkJoinPool));
        }
        System.out.println("🖥️ 쓰레드 수 기본: " + ForkJoinPool.getCommonPoolParallelism());
        CompletableFuture.allOf(trainings.toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                    long passeds = trainings.stream().map(CompletableFuture::join)
                            .filter(Objects::nonNull)
                            .count();
                    System.out.printf("🎖️ 합격자 : %d명%n", passeds);
                }).get();

    }

    public static CompletableFuture<Swordman> trainSwordmanWithFJP (ForkJoinPool fjp){
        return CompletableFuture.supplyAsync(() ->{
            takeTime(new Random().nextBoolean());
            return new Swordman(Side.BLUE);
        },fjp).exceptionally(e ->  {System.out.println("😭 탈락");
        return null;});
    }

    public static CompletableFuture<String> raceRunner (String name, ForkJoinPool fjp){
        return CompletableFuture.supplyAsync(() -> {
            takeTime(new Random().nextBoolean());
            System.out.printf("👟 %s 도착%n", name);
            return name;
        }, fjp).exceptionally(e -> null);
    }

    public static void anyOfEx () throws ExecutionException, InterruptedException {
        ArrayList<CompletableFuture<String>> runners = new ArrayList<>();

        String[] names =
                "철수,영희,돌준,병미,핫훈"
                        //"A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U"
                        .split(",");

        //  ⭐️ 경쟁할 쓰레드보다 풀 수가 적지 않도록
        //  - 3으로 줄여 볼 것 : 앞의 셋 중에서만 나옴
        ForkJoinPool forkJoinPool = new ForkJoinPool(names.length);

        Arrays.stream(names)
                .forEach(r -> runners.add(raceRunner(r, forkJoinPool)));

        //  💡 anyOf : 가장 먼저 완료된 결과물을 받아옴
        CompletableFuture.anyOf(
                        runners.stream()
                                .toArray(CompletableFuture[]::new)
                )
                .thenAccept(w -> {
                    System.out.println(
                            w != null
                                    ? ("🏆 1등: " + w)
                                    : "💣 지뢰 폭발"
                    );
                })
                .get();
    }
}
