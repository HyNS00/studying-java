package TIL.복습.생성자;

public class Normal {
    private String name;
    private int age;

    public Normal() {
        System.out.println("Person 생성자 실행");
    }

    public Normal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 이렇듯 매개변수가 있고 없고의 차이를 둘 수 있다.
    // 매개변수가 없는 생성자의 경우에는 객체를 생성할지 아래의 문장이 바로 출력된다 -> 메소드와의 차이
    // 아래의 생성자는 말 그대로 매개변수가 있는 생성자일뿐
}
