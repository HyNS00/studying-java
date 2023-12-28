package sec06.chap08;

import java.util.StringJoiner;

public class Ex04 {
    public static void main(String[] args) {
        // StringJoiner : 받은 문자열을 모아서 열고 닫는 문자열과 함께 join
        // 배열로만 받는 String.join보다 강력하고 유동적이다.

        String[] strAry = {"감자", "당근", "오이","양파"};
        // 구분자, 맨앞 , 맨뒤
        StringJoiner strJnr1 = new StringJoiner(",","<",">");
        StringJoiner strJnr2 = new StringJoiner("/","p","q");

        for (String s : strAry){
            strJnr1.add(s);
            strJnr2.add(s);
        }
        // 결과물을 문자열로 출력
        String joined1 = strJnr1.toString();
        String joined2 = strJnr2.toString();

        // 단일 쓰레드에서는 StringBuilder , 멀티쓰레드에서는 StringBuffer사용

        // 기본적으로 16개의 문자를 저장할 수 있는 공간을 가짐
        StringBuffer strBuffer1 = new StringBuffer(); // 기본 16
        StringBuffer strBuffer2 = new StringBuffer(2); // 내가 2로 설정
        StringBuffer strBuffer3 = new StringBuffer("Hello"); // 이럴경우 문자열 길이 + 16 = 21

        int[] capacities1 = {
                strBuffer1.capacity(), strBuffer2.capacity(), strBuffer3.capacity()
        };
        //  💡 값을 위와 같이 정한 이유:
        //  공간 증축(자원 소모)을 할 일을 최소화하도록 적당한 값을 준 것 뿐
        //  아래와 같이 문자들을 추가하면 필요한 만큼 증축됨
        //  append 메소드 : 인자로 주어진 문자열을 뒤에 이어붙임
        strBuffer1.append("안녕하세요~!");
        strBuffer2.append("안녕하세요~!");
        strBuffer3.append("안녕하세요~!");
        int[] capacities2 = {
                strBuffer1.capacity(), strBuffer2.capacity(), strBuffer3.capacity()
        };

        //  작업을 마친 뒤에는 toString 메소드로 문자열 생성 (최종본 프린트)
        String strBffr3Out = strBuffer3.toString();


        //  StringBuilder도 동일한 기능들 가짐
        StringBuilder strBldr1 = new StringBuilder("한놈");
        strBldr1.append("두시기");

        //  append 메소드는 해당 클래스의 인스턴스 반환
        //  - 메소드 체이닝 가능
        strBldr1
                .append("석삼")
                .append("너구리")
                .append("다섯놈");

        String strBldr1Out = strBldr1.toString();

        StringBuilder strBldr2 = new StringBuilder("0123456789");

        String strBldr2Out1 = strBldr2 // 범위의 문자열 지움
                .delete(3, 7).toString();

        String strBldr2Out2 = strBldr2 // 위치의 문자열 삭제
                .deleteCharAt(3).toString();

        String strBldr2Out3 = strBldr2 // 위치에 문자열 추가
                .insert(2, "ABC").toString();

        String strBldr2Out4 = strBldr2 // 범위의 문자열을 치환
                .replace(2, 4, "OneTwo").toString();

        String strBldr2Out5 = strBldr2 // 문자열 뒤집음
                .reverse().toString();

        //  메서드 체이닝으로 한 번에
        String strBldr2ChainOut = new StringBuilder("0123456789")
                .delete(3, 7)
                .deleteCharAt(3)
                .insert(2, "ABC")
                .replace(2, 4, "OneTwo")
                .reverse()
                .toString();


        StringBuilder strBldr3 = new StringBuilder("ABCDEFG");

        //  수동으로 저장공간 늘려주기
        //  - 작업할 전체 용량이 초기화 이후 계산되었을 때 유용
        strBldr3.setLength(100);
        int strBldr3Cap = strBldr3.capacity();

        //  주어진 범위만 문자열로 반환
        String strBldr3Substr = strBldr3.substring(2, 5);

        //  ⭐️ CharSequence 인터페이스
        //  - String, StringBuffer, StringBuilder 모두 이를 구현
        //  - Integer.parseInt 등의 메서드에 인자 타입으로 널리 사용
        //  - 메소드들 살펴볼 것

        CharSequence cs1 = "ABC";
        CharSequence cs2 = new StringBuffer();
        CharSequence cs3 = new StringBuilder();
    }
}
