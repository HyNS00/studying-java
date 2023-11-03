package sec03.chap05;

public class Ex04 {
    public static void main(String[] args) {
        //  💡 타 자료형으로부터 문자열로 변환
        String str1 = String.valueOf(true);
        String str2 = String.valueOf(false);
        String str3 = String.valueOf(123);
        String str4 = String.valueOf(3.14f);
        String str5 = String.valueOf('가');

        // String.valueOf 이렇게 하면 다른 자료형에서 문자열로 변경
        // 다른 자료형일지라도, + ""이걸 붙여주면 == 다른 자료형

        String str6 = true + "";
        String str7 = 123.45 + "";

        // 문자열을 정수자료형으로 변형하기
        String str123 = "123";
        // 문자열을 각각의 자료형으로 변환
        byte bytNum = Byte.parseByte(str123);
        short shortNum = Short.parseShort(str123);
        int intNum = Integer.parseInt(str123);
        long lngNum = Long.parseLong(str123);

        //  대소문자 무관 'true'일 때 true 반환
        boolean bool1 = Boolean.parseBoolean("TRUE");
        boolean bool2 = Boolean.parseBoolean("true");
        boolean bool3 = Boolean.parseBoolean("T");

        String strA = "A";

        //  다음 강에 배울 메소드
        char chr = strA.charAt(0);
    }
}
