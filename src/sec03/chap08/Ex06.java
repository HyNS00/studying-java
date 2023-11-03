package sec03.chap08;

public class Ex06 {
    public static void main(String[] args) {
        //  상수 배열의 경우
        final int[] NUMBERS = {1, 2, 3, 4, 5};
        //  ⚠️ 다른 배열을 할당하는 것은 불가
//        NUMBERS = new int[] {2, 3, 4, 5, 6};

        //  ⭐️ 배열의 요소를 바꾸는 것은 가능
        // final을 통해 NUMBERS의 값을 고정 , 변수의 값(배열)을 고정한거지 배열의 내용은 아님
        NUMBERS[0] = 11;
    }
}
