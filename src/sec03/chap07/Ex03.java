package sec03.chap07;

public class Ex03 {
    public static void main(String[] args) {
        // 실수를 다양하게 포매팅
        String [] fltFormats = {
                "%f",       // 기본(소수점 6자리, 그외는 0)
                "%.2f",     // 소수점 n자리 수 까지
                "%13.2f",   // 정수 자리 확보, 소수 자리 제한
                "%,f",      // 단위
                "%+013.2f",
                "%-13.2f"
        };
        String[] fltResults = new String[fltFormats.length];

        for (var i = 0; i < fltFormats.length; i++) {
            String format = (i + 1) + ". ";
            for (var j = 0; j < 4; j++) {
                format += fltFormats[i] + " ";
            }
            format = format.trim() + "%n%n";

            System.out.printf(format, 1.2, 123.456, 1234.123456789, -123.4567);

            fltResults[i] = format.formatted(1.2, 123.456, 1234.123456789, -123.4567);
        }
    }
}
