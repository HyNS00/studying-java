package Yalco.sec04.chap03;

public class Ex03 {
    public static void main(String[] args) {
        int count = 10;
        int[] multiOf4 = new int [count];
        // multiOf4라는 배열을 만들었고, 그 배열의 크기는 count의 크기와 같다
        for (int i =1, c=0; c < count; i++){
            if(i%4 == 0){
                multiOf4[c++] =i;
            }
        }
        //  💡 배열 순환 (기본적인 방법)
        for (int i = 0; i < multiOf4.length; i++) {
            System.out.println(multiOf4[i]);
        }

        // foreach방법 - 변수의 갯수를 줄여준다
        System.out.println("\n- - - - -\n");

        //  💡 for each 문법 - 배열이나 이후 배울 콜랙션 등에 사용
        for (int num : multiOf4) {
            System.out.println(num);
        }
        //for (type 변수명: iterate) {
        //    body-of-loop
        //}

        System.out.println("\n- - - - -\n");
        int sumOfArray = 0;
        for (int num : multiOf4){
            sumOfArray += num;
        }

        System.out.println("\n- - - - -\n");

        for (String s : "호롤롤로".split("")) {
            System.out.println(s);
        }
    }
}
