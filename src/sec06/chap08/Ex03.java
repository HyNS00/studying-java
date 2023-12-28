package sec06.chap08;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Ex03 {
    public static void main(String[] args) {
        long maxlong = Long.MAX_VALUE;

        // BigInteger 클래스
        // Long에서 다룰 수 있는 최대 정수 이상의 수를 다룰 수 있다.
        BigInteger bigInt1 = new BigInteger("123456789012345678901234567890");
        BigInteger bigInt2 = new BigInteger("987654321098765432109876543210");

        BigInteger bigInt3 = bigInt1.add(bigInt2);
        BigInteger bigInt4 = bigInt2.subtract(bigInt1);
        BigInteger bigInt5 = bigInt1.multiply(bigInt2);
        BigInteger bigInt6 = bigInt2.divide(bigInt1);

        // 외부에 있는 것이 더 크면 1, 인자가 더 크면 아니면  -1
        int bigIntCompare1 = bigInt1.compareTo(bigInt2);
        int bigIntCompare2 = bigInt2.compareTo(bigInt1);


        //  부동소수점 오차
        double num1 = 0.2 + 0.3f;
        double num2 = 0.3f * 0.7f;
        double num3 = 0.4 - 0.3;
        double num4 = 0.9f / 0.3;
        double num5 = 0.9 % 0.6;

        //  💡 BigDecimal 클래스
        //  - 부동소수점 오차를 해결

        float num6 = new BigDecimal("0.2")
                .add(new BigDecimal("0.3"))
                .floatValue();

        float num7 = new BigDecimal("0.3")
                .multiply(new BigDecimal("0.7"))
                .floatValue();

        float num8 = new BigDecimal("0.4")
                .subtract(new BigDecimal("0.3"))
                .floatValue();

        double num9 = new BigDecimal("0.9")
                .divide(new BigDecimal("0.3"))
                .doubleValue();

        double num10 = new BigDecimal("0.9")
                .remainder(new BigDecimal("0.6"))
                .doubleValue();
    }
}
