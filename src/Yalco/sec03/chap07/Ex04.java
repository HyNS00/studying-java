package Yalco.sec03.chap07;

public class Ex04 {
    public static void main(String[] args) {
        // 문자열 다양하게 포매팅
        String[] strFormats = {
                "%s",       // 기본
                "%9s",     // 자리확보
                "%.2s",     // ~글자만
                "%9.2s",    // 혼합
                "%-9s"      // 왼쪽정렬
        };
        String[] strResults = new String[strFormats.length];

        for (var i = 0; i < strFormats.length; i++) {
            String format = (i + 1) + ". ";
            for (var j = 0; j < 2; j++) {
                format += strFormats[i] + " ";
            }
            format = format.trim() + "%n%n";

            System.out.printf(format, "Hello", "하이염");

            strResults[i] = format.formatted("Hello", "하이염");
        }
    }
}
