package Yalco.sec05.chap04.ex03;

public class Product {
    private static double discount = 0.2;
    private static double increaseLimit = 1.2;

    private String name;
    private int price;

    public Product (String name, int price){
        this.name = name;
        this.price = price;
    }
    // getter and setter
    // 접근하고 값을 변경할 때 사용할 수 있다.
    // 즉 필드에 접근을 할 때 메소드를 통해 접근한다.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) return;
        this.name = name;
    }

    public int getPrice() {
        return (int) (price * (1 - discount));
    }

    public void setPrice(int price){
        int max = (int) (this.price * increaseLimit);
        this.price = price < max ? price : max;
    }

    // 만약 Getter Setter에서 자료형이 boolean일 경우
    // get이 아니라 is로 시작하는게 관례
}
