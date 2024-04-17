package Yalco.sec03.chap08;

public class Ex01 {
    public static void main(String[] args) {
        // 배열은 사용할 자료형에 []을 붙여서 사용한다
        char[] yutnori =  {'도', '개', '걸', '윷', '모'};

        // length : 배열의 인덱스를 반환
        int length = yutnori.length;

        // 인덱스는 []에 넣어서 접근
        char first = yutnori[0];
        char last = yutnori[yutnori.length - 1];


        // 초기화하지 않고 일단 선언하기
        boolean[] boolAry = new boolean[3];
        int[] intAry = new int[3];
        double[] dblAry = new double[3];
        char[] chrAry = new char[3]; // 아래 확인
        String[] strAry = new String[3];

        //  아스키 코드의 0번 글자. 문자열의 끝을 표시하는데 사용
        char NUL = chrAry[0];


        //  다음과 같이 원하는 위치의 값 변경
        intAry[0] = 123;
        intAry[1] = 456;
        intAry[2] = 789;
    }
}
