package Yalco.sec03.chap04;

public class Ex03 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 0, d = 0, e = 0, f = 0;

        boolean bool1 = a < b && c++ < (d += 3);
        boolean bool2 = a < b || e++ < (f += 3);

        boolean bool3 = a > b && c++ < (d += 3); // 🔴
        boolean bool4 = a > b || e++ < (f += 3);
        // short circuit
        // && 앞의 것이 false면 뒤의 것을 평가할 필요없음 -> 무조건 false
        // || 앞이 true면 뒤를 평가할 필요가없다 -> 무조건 true
    }
}
