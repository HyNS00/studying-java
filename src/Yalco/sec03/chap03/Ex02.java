package Yalco.sec03.chap03;

public class Ex02 {
    public static void main(String[] args) {
        char ch_a1 = 'A';
        int int_a1 = (int) ch_a1;


        // 정수를 얻는 다른 방법들
        int int_a2 = ch_a1 +0;
        int int_a3 = ch_a1 - 0;

        //  💡 리터럴에 더할 때와 변수에 더할 때 반환 자료형이 다름
        char ch_a2 = 'A' + 1;
        //char ch_a3 = ch_a1 + 1; // ⚠️ 불가
        int int_a4 = ch_a1 + 1;

        //  💡 int 1과 char '1'은 다름! - 문자로서의 '1'
        //  - 해당 문자의 정수값 확인
        char ch_b1 = '1';
        char ch_b2 = '2';

        //  ⚠️ 숫자 문자에 사칙연산 - 문자 번호 기준 결과 반환
        char ch_b3 = '1' + '2';
        int int_b4 = ch_b1 + ch_b2;

        // 문자가 의미하는 정수로 변환
        int d1 = Character.getNumericValue('1');
        int d2 = Character.getNumericValue('2');

        //  ⚠️ 빈 문자는 사용 불가, 공백(space)는 가능
        //  - 이후 배울 문자열(String)과의 차이
//        char empty = ''; char형은 빈칸이 허용되지 않는다, 스페이스가 포함되어야함
        String emptyStr = "";

        char space = ' ';
    }
}
