package sec03.chap06;

public class Ex07 {
    public static void main(String[] args) {
        // 이어붙이기
        // concat : 문자열을 이어붙이기
        String str_a1 = "슉-";
        String str_a2 = "슈슉-";
        String str_a3 = "슈슈슉-";

        String str_a4 = str_a1 + str_a2 + str_a3;
        String str_a5 = str_a1.concat(str_a2);

        // 메서드 체이닝 -> 메서드를 반복해서 사용
        String str_a6 =str_a1.concat(str_a2)
                .concat(str_a3)
                .concat(str_a4)
                .concat(str_a5);
        // concat은 문자열만 사용가능 나머지는 +로 붙이자

        String str_b1 = "ABC";
        String str_b2 = str_b1 + true + 1 + 2.34 + '가';
        String str_b3 = str_b1;


        // concat은 필요시에만 새 인스턴스를 생성한다
        String str_b4 = str_b1 +"";
        String str_b5 = str_b1.concat("");
        int str_b1Hash = System.identityHashCode(str_b1);
        int str_b4Hash = System.identityHashCode(str_b4);
        int str_b5Hash = System.identityHashCode(str_b5);


        //  3. null이 포함될 경우

        String str_c1 = null;

        //  + 연산자는 null과 이어붙이기 가능
        String str_c3 = str_c1 + null + "ABC";

        //  ⚠️ concat은 NullPointerException 발생
        //String str_c4 = str_c1.concat("ABC");
        //String str_c5 = "ABC".concat(str_c1);

        // 다중 연산시 생성되는 문자열 인스턴스의 수가 다름
        String str_d1 = "a" + "b" + "c" + "d";

        // 연산 최적화
        String str_d2 = new StringBuilder("a")
                .append("b")
                .append("c")
                .append("d")
                .toString(); // abcd가 생성됨
        // "a", "b", "c", "d", "abcd"가 생성되어 메모리 차지

        // concat은 매 번 문자열은 반환한다
        String str_d3 = "a"
                .concat("b") // "ab"가 생성됨
                .concat("c") // "abc"가 생성됨
                .concat("d"); // "abcd"가 생성됨
        // "a", "b", "c", "d", "ab", "abc", "abcd"가 생성되어 메모리 차지


    }
}
