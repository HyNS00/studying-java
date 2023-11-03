package sec05.chap02.ex03;

public class Main {
    public static void main(String[] args) {
        ChickenMenu[] menus = {
                new ChickenMenu("후라이드",10000),
                new ChickenMenu("양념",12000),
                new ChickenMenu("화덕구이",15000,"bake")
        };

        ChickenMenu sample = new ChickenMenu("test",222);
        System.out.println(sample.cook);
        YalcoChicken store1 = new YalcoChicken(3,"판교",menus);

        ChickenMenu order1 = store1.orderMenu("양념치킨");
        ChickenMenu order2 = store1.orderMenu("오븐구이");

    }
}
