package sec04.chap02;

public class Ex02 {
    public static void main(String[] args) {
        String direction = "north";
        String dirKor; //변수를 선언하고 초기화만 진행한 상태

        switch (direction) {
            case "north":
                dirKor ="북"; // 초기화한 변수에 값을 넣어줌

                break;
            case "south":
                dirKor = "남";
                break;
            case "east":
                dirKor = "동";
                break;
            case "west":
                dirKor = "서";
                break;
            default:
                dirKor = null;
        }
        System.out.println(
                dirKor != null ? dirKor : "무효"
        );
    }
}
