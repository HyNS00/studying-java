package sec04.chap02;

public class Ex01 {
    public static void main(String[] args) {
        // switch 문 : 괄호 안에 기준이 될 변수를 받음

        // break가 없는 곳까지 실행됨
        int fingersOut = 2;
        switch (fingersOut) {
            // case : 기준에 일치하는 case로 바로 이동
            // break : switch문 실행을 종료
            // default : 해당하는 case가 없을 때 마지막에 작성

            case 2:
                System.out.println("가위");
                break;

            case 0:
                System.out.println("바위");
                break;

            case 5 :
                System.out.println("보");
                break;
            default:
                System.out.println("무효");
        }
    }
}
