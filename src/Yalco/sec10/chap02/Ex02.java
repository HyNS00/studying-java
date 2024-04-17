package Yalco.sec10.chap02;
import Yalco.sec07.chap04.*;

import java.util.stream.IntStream;

public class Ex02 {
    public static void main(String[] args) {
//        withFinally1(false);
//        System.out.println("\n- - - - -\n");
//        withFinally1(true);
//
//        System.out.println("\n- - - - -\n");
//
//        char char1 = withFinally2(3);
//        char char2 = withFinally2(6);

        System.out.println("\n- - - - -\n");

        IntStream.rangeClosed(0, 4)
                .forEach(i -> withFinally3(i));
    }

    public static void withFinally1 (boolean makeException){
        try{
            if (makeException)  {
                System.out.println("".charAt(0));
            }
            System.out.println("정상 실행");
        } catch (Exception e){
            System.out.println("예외 발생");
        } finally{
            System.out.println("무조건 실행 🙏");
        }
        //  ❓ 그냥 try 문 밖에 적으면 안 될까?
        System.out.println("🏁 이렇게 말이지.");
        // 여기서는 가능

    }

    // try -catch 문 밖에서 적는 경우
    public static char withFinally2(int index){
        String str = "Hello";
        try{
            char result = str.charAt(index);
            System.out.println("정상 실행");
            return result;
        } catch (Exception e){
            System.out.println("예외 발생");
            return '!';
        } finally {
            // 보통의 경우 return이 있다면, try-catch문 종료
            // finally는 return값이 존재하더라도 실행됨
            System.out.println("무조건 실행");
        }
        //  💡 try, catch 블록에 모두 return이 있으므로
        //  이 부분은 작성될 수 없음
//          System.out.println("🏁 이렇게 말이지.");
    }

    //  💡 다중 catch 문 이후에도 사용됨
    public static void withFinally3 (int i) {
        try {
            switch (i) {
                case 1:
                    System.out.println((new int[1])[1]);
                case 2:
                    System.out.println("abc".charAt(3));
                case 3:
                    System.out.println((Knight) new Swordman(Side.RED));
                case 4:
                    System.out.println(((String) null).length());
            }
            System.out.printf("%d: 🎉 예외 없이 정상실행됨%n", i);

        } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
            System.out.printf("%d : 🤮 범위를 벗어남%n", i);
        } catch (ClassCastException e) {
            System.out.printf("%d : 🎭 해당 클래스로 변환 불가%n", i);
        } catch (Exception e) {
            System.out.printf("%d : 🛑 기타 다른 오류%n", i);
        } finally {
            System.out.println("🏁 무조건 실행");
        }
    }
}
