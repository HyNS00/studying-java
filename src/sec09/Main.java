package sec09;

public class Main {
    public static void main(String[] args) {
        // 익명 클래스를 통해 추상메소드 구현
        Printer printer1 = new Printer(){
            @Override
            public void print(){
                System.out.println("람다식이 없을 때");
            }
        };

        // 람다식으로 변경
        Printer printer2 = () -> {
            System.out.println("인자, 반환값이 없는 람다식");
        };

        // 방금 위의 람다식을 더 수정할 수 있다
        Printer printer3 = () -> System.out.println("{}없앤 람다식");
        // 메소드 안에 한줄 밖에 존재하지 않는다면 { } 생략도 가능

        // 단 코드가 여러 줄 일때는 필요
        Printer printer4 = () -> {
            System.out.println("코드가 여러줄");
            System.out.println(" { } 필요");
        };

        for (Printer p : new Printer[] {printer1, printer2, printer3, printer4}) {
            p.print();
        }


        System.out.println("\n------------------------\n");

        Returner returner1 = () -> {return 1;};
        Returner returner2 = () -> 1; // 반환값이 이렇게 하나라면 생략가능
        Returner returner3 = () -> "반환값이 하나일시 return 과 { }을 모두 생략가능";

        Object returned1 = returner1.returnObj();
        Object returned2 = returner3.returnObj();

        // 인자가 존재할 때 -> 자료형도 같이 쓰지 않는다.
        SingleParam square = (i) -> i * i;
        // 인자가 하나일 시 ( )생략가능
        SingleParam cube = i -> i * i * i;

        int _2_square = square.func(2);
        int _3_cube = cube.func(3);


        DoubleParam add = (a, b) -> a + b; // IDE에서 많이 도와주니 가독성있게 바꿔보자
        DoubleParam multiAndPrint = (a,b) ->{
            int result = a*b;
            System.out.printf("%d * %d = %d%n",a,b,result);
            return result;
        };

        int added = add.func(2,3);
        int multipled = multiAndPrint.func(2,3);

    }
}
