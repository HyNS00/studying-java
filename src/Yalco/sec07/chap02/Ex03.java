package Yalco.sec07.chap02;

public class Ex03 {
    public static void main(String[] args) {
        // 래퍼 클래스의 대표+ 유용한 메소드들
        // CharSequence로부터 인스턴스 변환
        // CharSequence : String 등이 구현하는 인터페이스
        Integer int1 = Integer.valueOf("123");

        // 오토 언박싱으로 가능
        int int33 = Integer.valueOf("123");

        // 원시값을 반환
        // 다른 숫자, 불리언 래퍼 자료형들에도 존재 (parseDouble, parseBoolean...)
        int int2 = Integer.parseInt("123"); // 원시값 반환

        // parseInt(CharSequence, 진수)
        // 정수 자료형들에만 존재
        int int_123_oct = Integer.parseInt("123", 8);
        int int_123_dec = Integer.parseInt("123", 10);
        int int_123_hex = Integer.parseInt("123", 16);

        //  parseInt(CharSequence, 시작위치, 끝위치, 진수)
        int int3 = Integer.parseInt("1234567", 3, 5, 10);


        // 문자 클래스 메소드
        String strSample = "Ab가1 .";
        for (int i =0; i < strSample.length(); i++){
            Character c= strSample.charAt(i);
            System.out.printf(
                    "[%c] : L : %b, U: %b, L: %b, D: %b, S: %b%n", // %b는 boolean
                    c,
                    Character.isLetter(c), // 문자인지
                    Character.isUpperCase(c), // 대문자
                    Character.isLowerCase(c), // 소문자
                    Character.isDigit(c), // 숫자인지
                    Character.isSpaceChar(c)
            ); // 공백문자인지
        }

        // 문자열 반환 (Object에서 오버라이드)
        String intStr = int1.toString();
        String dblStr = Double.valueOf(3.14).toString();
        String blnStr = ((Boolean) false).toString();
        String blnStr2 = String.valueOf(false);
        // toString()은 객체에게서만 가능
        String chrStr = new Character('A').toString();

        // 인스턴스끼리의 value비교
        Integer intA = 12345;
        Integer intB = 12345;

        boolean compByOp1 = intA == intB; // ==은 둘이 동일한 인스턴스인지 비교한다, 따라서 faluse
        boolean compByOp2 = intA.equals(intB);

        Short srtA = 12345;
        // 자료형이 다르면 false 반환
        boolean compByOp3 = intA.equals(srtA);

        //  숫자 자료형 간 변환 - Number의 추상 메소드들

        Byte int1Byt = int1.byteValue();
        Double int1Dbl = int1.doubleValue();

        Integer int4 = 123456789;
        Byte int4Byt = int4.byteValue(); // ⚠️ 자료형보다 값이 큼

        Float flt1 = 1234.5678f;
        Integer flt1Int = flt1.intValue(); // ⚠️ 소수점 이하 버림
        Short int1DblSrt = int1Dbl.shortValue();


    }
}
