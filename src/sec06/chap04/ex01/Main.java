package sec06.chap04.ex01;

import sec05.chap08.ex01.*;

public class Main {
    public static void main(String[] args) {
        YalcoGroup store1 = new YalcoChicken("울산");
        YalcoGroup store2 = new YalcoCafe("창원", true);

        YalcoGroup store3 = new YalcoGroup (1,"포항"){
            @Override
            public void takeOrder() {
                System.out.printf("유일한 얄코과메기 %s 과메기를 주문해주세요.%n",super.intro());
//                dryFish();
            }

            public void dryFish(){
                System.out.println("과메기 말리기");
            }
        };

        String store3Intro = store3.intro();
        store3.takeOrder();
        // store3.dryFish()  -> 불가
        // 만약 dryFish()메소드를 쓰고 싶다면 takeOrder 안에 추가해보자
        System.out.println("\n- - - - - -\n");
        // 익명 클래스도 YalcoGroup이므로 하나로 묶일 수 있다.
        for (YalcoGroup store : new YalcoGroup[] {store1,store2,store3}){
            store.takeOrder();
        }
    }
}
