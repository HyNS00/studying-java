package sec04.chap04;

public class Ex04 {
    public static void main(String[] args) {
        final int LINE_WIDTH = 5;

        int lineWidth = LINE_WIDTH;

        while (lineWidth > 0) {
            int starsToPrint = lineWidth--;
            while (starsToPrint-- > 0) { // 값이 0보다 클 때까지 반복 print
                System.out.print("*");
            }
            System.out.println(); // 엔터역할
        }
        //  for 문으로 다시 작성
        for (int i = LINE_WIDTH; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("@");
            }
            System.out.println();
        }

    }
}
