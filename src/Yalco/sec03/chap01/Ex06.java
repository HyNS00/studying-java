package Yalco.sec03.chap01;

public class Ex06 {
    public static void main(String[] args) {
        int a = 1;
        a = a +2; // 3

        a += 3; // 6

        int b = a += 4; // 10

        // 추가
        int i1 = 0;
        int i2 = 1;
        int i3 = (i1 = i2); // 1

        String s1 ="ABC";
        String s2 ="가나다";
        String s3 = s1 + s2;
        String s4 = (s1 = s2);


        int x =3;
        x += 2;
        x -= 3;
        x *= 12;
        x /= 3;
        x %= 5;
    }
}
