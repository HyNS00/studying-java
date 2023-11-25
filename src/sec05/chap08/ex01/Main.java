package sec05.chap08.ex01;

public class Main {
    public static void main(String[] args) {
        // 추상 클래스는 그 자체로 인스턴스를 생성할 수 없다
//        YalcoGroup yalcoGroup = new YalcoGroup(1,"서울");
        YalcoChicken ychStore1 =  new YalcoChicken("판교");
        YalcoChicken ychStore2 =  new YalcoChicken("강남");

        YalcoCafe ycfStore1 = new YalcoCafe("울릉",true);
        YalcoCafe ycfStore2 = new YalcoCafe("강릉", false);

        YalcoGroup[] ycStores = {
                ychStore1,ychStore2,
                ycfStore1,ycfStore2
        };
        // 하위클래스들이므로 상위 클래스인 YalcoGroup배열에 담을 수 있다. - 다형성
        for (YalcoGroup ycStore : ycStores) {
            ycStore.takeOrder();
        }
        System.out.println("\n- - - - -\n");

        System.out.println(YalcoChicken.getCreed());
        System.out.println(YalcoCafe.getCreed());

    }
}
