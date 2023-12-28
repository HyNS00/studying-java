package sec06.chap08;

import java.util.Random;

public class Ex02 {
    public static void main(String[] args) {
        // random 관련 메소드
        Random random = new Random();
        // 시드 지정
        random.setSeed(1234);
        // 범위 미지정시 범위가 완전 랜덤으로 나온다.
        int randInt1 = random.nextInt();
        int randInt2 = random.nextInt();
        int randInt3 = random.nextInt();

        // 범위 지정(이상, 미만)
        int randInt4 = random.nextInt(0,10);
        int randInt5 = random.nextInt(0, 10);
        int randInt6 = random.nextInt(0, 10);

        double randDbl1 = random.nextDouble();
        double randDbl2 = random.nextDouble();
        // 범위 지정 (이상, 미만)
        double randDbl3 = random.nextDouble(3.14, 5.67);
        double randDbl4 = random.nextDouble(3.14, 5.67);

        boolean randBln1 = random.nextBoolean();
        boolean randBln2 = random.nextBoolean();
    }
}
