package sec04.chap07;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int repeatCount = sc.nextInt();
            for (int i = 0; i < repeatCount; i++){
                // print : 같은 줄에 이어붙여서 출력
                System.out.print("호우 ");

            }
            System.out.println("");
        }
        sc.close();
    }

}
