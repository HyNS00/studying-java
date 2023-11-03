package sec04.chap02;

public class Ex04 {
    public static void main(String[] args) {
        byte month = 1;
        byte season;

        // 연속된 케이스문
        switch (month){
            case 1: case 2: case 3: // case 1 , 2 ,3 모두 해당
                season =1;
                break;

            case 4:
            case 5:
            case 6:
                season = 2;
                break;
            // 위와 같은 표현
            case 7: case 8: case 9:
                season = 3;
                break;
            case 10: case 11: case 12:
                season = 4;
                break;
            default:
                season = 0;
        }
        System.out.println(
                season > 0 ? "지금은 %d분기 입니다".formatted(season)
                        : "무효한 월입니다"
        );
    }
}
