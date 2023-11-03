package sec03.chap06;

public class Ex02 {
    public static void main(String[] args) {
        // 빈문자열인지 판단
        String str1 = "";
        String str2 = "\t\n3";

        int i1 = str1.length();
        int i2 = str2.length();

        // isEmpty() -> 문자열의 길이가 0인지 여부
        boolean b1 = str1.isEmpty();
        boolean b2 = str2.isEmpty();

        // isBlank() -> 공백을 제외한 문자열의 길이가 0인지 여부
        boolean b3 = str1.isBlank();
        boolean b4 = str2.isBlank();


        // trim
        String str3 = "\t 에 네 르 기 파!! \n";

        //  💡 trim : 앞뒤의 공백(white space) 제거
        String str4 = str3.trim();

        // 변수 그자체에 적용하기
        str3 = str3.trim();

    }
}
