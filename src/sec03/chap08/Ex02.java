package sec03.chap08;

public class Ex02 {
    public static void main(String[] args) {
        // 초기화 블록을 사용한 선언 동시 초기화
        char[] dirAry1 ={'동','서','남','북'};
        char[] dirAry2 = new char[] {'동','서','남','북'};

        char[] dirAry3;
        dirAry3 = new char[] {'동', '서', '남', '북'};

        int [] intAry = {1, 2, 3, 4, 5};

        //  ⚠️ 런다임 에러: ArrayIndexOutOfBoundsException
//        int outOfAry = intAry[intAry.length];
    }
}
