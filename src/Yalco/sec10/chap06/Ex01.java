package Yalco.sec10.chap06;

import java.util.Random;

public class Ex01 {
    public static void main(String[] args) {
//        String nulStr  = null;
//        System.out.println(nulStr.length()); // npe오류

//        System.out.println(
//                catOrNull().length()  // 반복실행해 볼 것
//        ); // null 일 때는 npe 오류 발생

        // try -catch로 npe 대비
        try{
            System.out.println(
                    catOrNull().length()
            );
        }catch (NullPointerException npe){
            npe.printStackTrace();
            System.out.println(0); // 대체값
        }

    }
    public static String catOrNull(){
        return new Random().nextBoolean() ? "cat" : null;
    }
}
