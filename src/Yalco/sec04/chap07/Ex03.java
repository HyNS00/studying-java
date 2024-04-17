package Yalco.sec04.chap07;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("불리언을 입력해주세요");
//
//        // 다음 값이 특정 자료형으로 읽힐 수 있는지 확인
//        while (sc.hasNextBoolean()) {
//            //대소문자 무관 비교
//            System.out.println("입력값" + sc.nextBoolean());
//            // .hasNextBoolean : Boolean값으로 입력이 되어있어서 읽을 수 있는지 아닌지 판단
//
//        }
//        sc.close();
        // 정수버전
//        System.out.println("정수를 입력해주세요");
//        while (sc.hasNextInt()) {
//            System.out.println("입력값 :" + sc.nextInt());
//        }
//        sc.close();
        System.out.println("단어를 입력해주세요.");

        while (sc.hasNext()) {
            String nextWord = sc.next();
            if (nextWord.equalsIgnoreCase("quit")) break;
            System.out.println("입력값: " + nextWord);
        }

        System.out.println("문장을 입력해주세요.");

        while (sc.hasNextLine()) {
            String nextSentence = sc.nextLine();
            if (nextSentence.equalsIgnoreCase("quit")) break;
            System.out.println("입력값: " + nextSentence);
        }

        sc.close();

        // hasNextLine :입력이 다음 줄에 존재한다면 True, 아니면 False
        // nextLine : 엔터를 감지
    }
}
