package sec06.chap01;

public class Ex01 {
    public static void main(String[] args) {
        {
            //  💡 { } 로 블록 생성
            int intNum= 123;
            String str = "블록 밖은 위험해";

        }
        // 블록 안에서 선언된 것은 밖에서 사용불가
//        intNum = 234;
//        System.out.println(str);

        String x = "전국구 보스";

        {
            String y = "동네 양아치";

            //  💡 블록 안쪽에서는 바깥의 것 사용 가능
            System.out.println(x);
            System.out.println(y);
        }

        System.out.println(x);
//        System.out.println(y); // ⚠️ 불가

        // 블록 밖에서 생성된 것은 블록 안에서도 볼 수 있다.
        // 대표적인 예시로 for
        int z = 1;
        for(int i = 0; i < 5; i++){
            System.out.println(z+i);
        }
//        System.out.println(i);

        // 위의 for문에서와 같이 z는 { }블록 밖에서 생성된 것이므로 for문 블록에서도 사용이 가능하지만
        // i는 블록 밖에서는 표현할 수 가 없다.

    }
}
