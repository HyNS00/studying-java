package Yalco.sec03.chap01;

public class Ex01 {
    public static void main(String[] args) {
        byte _1b_byte = 1;
        short _2b_short = 2;
        int _4b_int = 3; // ⭐️ 일반적으로 널리 사용
        long _8b_long = 4;

        // 묵시적 형변환
        // 작은 데이터의 크기를 큰 데이터의 형식으로 옮길 수 있다
        // 자동으로 데이터의 형태도 변환

        //  큰 자료형에 작은 자료형의 값을 넣을 수 있음
        //  💡 묵시적(암시적) 형변환
        _2b_short = _1b_byte;
        _4b_int = _1b_byte; _4b_int = _2b_short;
        _8b_long = _1b_byte; _8b_long = _2b_short; _8b_long = _4b_int;


        //  ⚠️ 작은 자료형에 큰 자료형의 값을 '그냥' 넣을 수 없음
        //  들어있는 값의 크기와 무관
//        _1b_byte = _2b_short; _1b_byte = _4b_int; _1b_byte = _8b_long;
//        _2b_short = _4b_int; _2b_short = _8b_long;
//        _4b_int = _8b_long;

        //  ⭐ int의 범위를 벗어나는 수에는 리터럴에도 명시 필요
        //  끝에 l 또는 L을 붙여 볼 것
        long _8b_long1 = 123456789123456789L;
        // int의 크기를 벗어난 수를 넣을것이라면 뒤에 l,L을 붙임으로써 넣을 수 있따

        //  💡 가독성을 위해 아래와 같이 표현 가능 (자바7부터)
        int _4b_int2 = 123_456_789;
        long _8b_long2 = 123_456_789_123_456_789L;
    }
}
