package sec03.chap04;

public class Ex04 {
    public static void main(String[] args) {
        // 삼항연산자 ->a ? b:c
        // a = 불리언값, b = a가 참일 때, c =a 가 거짓일 때
        int num1 = 3, num2 = 4;

        char num1OE = num1 % 2 == 1 ? '홀' : '짝';
        char num2OE = num2 % 2 == 1 ? '홀' : '짝';

        // 연속된 문장으로 사용 가능
        int num = 3;

        //  아래 값들을 바꿔가며 실행해 볼 것
        boolean mult2 = true;
        //mult2 = false;

        boolean plus5 = true;
        //plus5 = false;

        System.out.println(
                (!mult2 && !plus5) ? num
                        : (mult2 && plus5) ? num * 2 + 5
                        : mult2 ? num * 2
                        : num + 5
        );
    }
}
