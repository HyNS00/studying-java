package sec03.chap06;

public class Ex09 {
    public static void main(String[] args) {
        // 배열로 반환
        String str1 = "가나다라마";
        String str2 = "010-1234-5678";
        String str3 = "하나 둘 셋 넷 다섯";

        // toCharArray : 문자열을 분리하여 문자열의 배열로 반환
        char [] chAry1 = str1.toCharArray();
        char [] chAry2 = str3
                .replace(" ", "") // 공백을 없애고 문자열로
                .toCharArray();

        // split : 주어진 기준으로 (~개까지) 분할하여 문자열배열로 반환
        String[] strAry1 = str1.split("");
        String[] strAry2 = str2.split("-");
        String[] strAry3 = str3.split(" ");
        String[] strAry4 = str3.split(" ", 3);
        // limit은 문자열의 갯수를 제한한다 3개로 제한한모습
    }
}
