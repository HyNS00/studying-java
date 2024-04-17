package Yalco.sec10.chap02;
import Yalco.sec07.chap04.*;

import java.util.stream.IntStream;

public class Ex01 {
    public static void main(String[] args) {
//        IntStream.rangeClosed(0,4).forEach(Ex01::tryThings1);

        System.out.println("\n- - - - -\n");

//        IntStream.rangeClosed(0, 4)
//                .forEach(Ex01::tryThings2);
//
//
//        System.out.println("\n- - - - -\n");

        IntStream.rangeClosed(0, 4)
                .forEach(Ex01::tryThings3);
    }
    public static void tryThings1 (int i){
        try{
            switch (i){
                // 예외발생시 catch문으로 이동
                case 1: System.out.println((new int[1])[1]);
                case 2: System.out.println("abc".charAt(3));
                case 3: System.out.println((Knight) new Swordman(Side.RED));
                case 4: System.out.println(((String) null).length());

            }
            //  ⭐️ 아래의 코드는 예외가 발생하면 실행되지 않음
            System.out.printf("%d: 🎉 예외 없이 정상실행됨%n", i);
        } catch (Exception e){
            System.out.printf(
                    "%d : [%s] %s%n",i,e.getClass(),e.getMessage()
            );
            e.printStackTrace();
        }
    }

    public static void tryThings2 (int i){
        try{
            switch (i){
                case 1: System.out.println((new int[1])[1]);
                case 2: System.out.println("abc".charAt(3));
                case 3: System.out.println((Knight) new Swordman(Side.RED));
                case 4: System.out.println(((String) null).length());
            }
            System.out.printf("%d: 🎉 예외 없이 정상실행됨%n", i);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.printf("%d : 🍡 배열의 크기를 벗어남%n", i);
        } catch (StringIndexOutOfBoundsException e){
            System.out.printf("%d : 🔤 문자열의 길이를 벗어남%n", i);
        } catch (ClassCastException e){
            System.out.printf("%d : 🎭 해당 클래스로 변환 불가%n", i);
        } catch (Exception e){
            //  💡 위에서 처리되지 못한 모든 타입의 오류
            //  ⭐️ 가장 아래에 있어야 함 -> 내려오면서 위에서 catch하지 못한 에러를 처리하는 것
            System.out.printf("%d : 🛑 기타 다른 오류%n", i);
        }
    }

    public static void tryThings3(int i){
        try{
            switch (i){
                case 1: System.out.println((new int[1])[1]);
                case 2: System.out.println("abc".charAt(3));
                case 3: System.out.println((Knight) new Swordman(Side.RED));
                case 4: System.out.println(((String) null).length());
            }
            System.out.printf("%d: 🎉 예외 없이 정상실행됨%n", i);
        } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e){
            // 둘 이상의 예외타입들이 동일하게 대응할 때
            System.out.printf("%d : 🤮 범위를 벗어남%n", i);
        } catch (ClassCastException e){
            System.out.printf("%d : 🎭 해당 클래스로 변환 불가%n", i);
        } catch (Exception e){
            System.out.printf("%d : 🛑 기타 다른 오류%n", i);
        }

    }
}
