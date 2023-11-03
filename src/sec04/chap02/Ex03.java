package sec04.chap02;

public class Ex03 {
    public static void main(String[] args) {
        //  💡 break 관련 동작방식을 이용
        // break가 없다면 해당 case에서 멈추고 그 다음 break를 만날 때까지 계속 진행
        char yutnori = '개';

        switch (yutnori) {
            case '모': System.out.println("앞으로");
            case '윷': System.out.println("앞으로");
            case '걸': System.out.println("앞으로");
            case '개': System.out.println("앞으로");
            case '도': System.out.println("앞으로"); break;
            default:
                System.out.println("무효");
        }
    }
}
