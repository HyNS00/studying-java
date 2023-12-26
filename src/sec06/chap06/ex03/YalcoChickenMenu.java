package sec06.chap06.ex03;
// 열거형도 클래스와 비슷하게 생성자,필드, 메소드를 가질 수 있다.
public enum YalcoChickenMenu {
    FR("후라이드",10000,0),
    YN("양념치킨",12000,1),
    GJ("간장치킨",12000,0),
    RS("로제치킨",14000,0),
    PP("땡초치킨",13000,2),
    XX("폭렬치킨",13000,3);

    private String name;
    private int price;
    private int spicyLevel;

    // 생성자
    YalcoChickenMenu(String name, int price, int spicyLevel){
        this.name = name;
        this.price = price;
        this.spicyLevel = spicyLevel;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String getDesc(){
        String peppers = "";
        if (spicyLevel > 0) {
            peppers = "️⭐".repeat(spicyLevel);
        }
        return "%s %d 원 %s".formatted(name,price,peppers);
    }

}
