package Yalco.sec10.chap01;

public class Main {
    public static void main(String[] args) {
        Throwable throwable;
        Error error;
        Exception exception;
        OutOfMemoryError outOfMemoryError;
        StackOverflowError stackOverflowError;
        RuntimeException runtimeException;
        IndexOutOfBoundsException indexOutOfBoundsException;

        // try ~ catch문
        int[] ints = {1,2,3};
//        System.out.println(ints[3]); //⚠️ 런타임 에러
//        System.out.println("예외를 발생시키지 않았을 때");


        // try -catch문 사용
        try{
            System.out.println(ints[3]);
        } catch (Exception e){
            String errMsg = e.getMessage();
            System.out.println(errMsg); // 예외에 대한 간략 정보 문자열로 반환
            e.printStackTrace(); //에러의 종류, 발생위치, 전반 단계 (호출스택) 출력
        }
        System.out.println("예외를 try-catch문으로 했을 때");

    }
}
