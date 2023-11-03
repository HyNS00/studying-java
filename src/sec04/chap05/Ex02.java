package sec04.chap05;

public class Ex02 {
    public static void main(String[] args) {
        // 반환한다는 것은 바꿔 쓸 수 있다는 말이다
        int int1 = add(2,3);
        System.out.println(int1);

        System.out.println(add(4,5));

        int int2 = add(add(6,7), add(7,8));
        System.out.println(int2);

        System.out.println("\n- - - - -\n");

        if (
                checkIfContain(
                        "Hello World",
                        "hello"
                )
        ) {
            System.out.println("포함됨");
        } else {
            System.out.println("포함 안됨");
        }
    }
    static int add (int num1, int num2){
        return num1 + num2;
    }
    static boolean checkIfContain (String text, String token) {
        return text.toLowerCase().contains(token.toLowerCase());
    }

}
