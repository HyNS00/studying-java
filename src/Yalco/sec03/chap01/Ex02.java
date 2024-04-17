package Yalco.sec03.chap01;

public class Ex02 {
    public static void main(String[] args) {
        byte byteNum;
        int smallIntNum = 12;

        // 명시적 형변환
        byteNum = (byte) smallIntNum;

        int intNum = 12345;

        byteNum = (byte) intNum; // 데이터 값 손실
        // byte는 최대 127까지만 가능함
        // 12345 % 128
    }

}
