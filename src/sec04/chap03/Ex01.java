package sec04.chap03;

public class Ex01 {
    public static void main(String[] args) {
        // for문
        for (int i = 0; i <10; i++){
            System.out.println(i);
        }

        for (int i =0; i <10;){
            System.out.println(i);
            i +=2;
        }

        for (double d = 123.24; d > 0; d-=32.1){
            System.out.println(d);
        }
        for (String s =""; s.length() < 11; s+= s.length()){
            System.out.println(s);
        }

        System.out.println("\n- - - - -\n");

        // 쉼표로 구분하여 여럿 사용 가능
        // 변수의 자료형은 한 종류만 가능하다
        for (byte a =0,b= 10; a <= b;){
            System.out.printf("a : %d, b:%d%n",a++,b--);
        }

        System.out.println("\n- - - - -\n");

        //  윷놀이 예제에 적용
        String yuts = "도개걸윷모";
        char yut = '도';
        boolean isValid = false;
        for (int i = 0; i <= yuts.indexOf(yut); i++){
            isValid = true;
            System.out.println("앞으로");

        }
        if (!isValid) System.out.println("무효");
    }
}
