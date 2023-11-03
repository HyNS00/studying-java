package sec03.chap07;

public class Ex02 {
    public static void main(String[] args) {
        System.out.printf("%d,%5d,%05d%n -----%n%n",123,123,123);

        // 정수 다양하게 포매팅하기
        String [] intFormats ={
                "%d",            // 기본
                "%13d",          //  n자리 수 확보, 오른 쪽 정렬
                "%013d",        //  n자리수 확보 하고 남은 빈자리는 0으로 채움
                "%+13d",        //  양수는 앞에 +를 붙인다, 음수는 그대로
                "%,13d",        // 쉼표 사용 단위
                "%-13d",        // 자리수 확보, 왼쪽으로 정렬
                "%+,013d"       //
        };
        String[] intResults = new String[intFormats.length];
        for (var i = 0; i < intFormats.length; i++) {
            String format = (i + 1) + ". ";
            for (var j = 0; j < 4; j++) {
                format += intFormats[i] + " ";
            }
            format = format.trim() + "%n%n";  // "%d %d %d %d%n%n" ...
              System.out.println(format); // 🔍 주석해제하여 함께 확인

            //  🔍 이 숫자들을 스페이스로 구분해서 출력해 볼 것
            System.out.printf(format, 12, 2345, 67890, -1234567);

            //  ⭐️ formatted 메소드에서도 사용 가능
            intResults[i] = format.formatted(12, 2345, 67890, -1234567);
        }
    }
}
