package Yalco.sec05.chap01.ex03;

public class YalcoChicken {
    int no;
    String name;


    // 생성자 : 인스턴스를 만드는 메소드
    // this : 생성될 인스턴스를 가리킴
    public YalcoChicken(int no, String name){
        this.no = no;
        this.name = name;
    }
    // 메소드
    // string 자료형
    String intro() {
        return "안녕하세요, %d호 %s점 입니다.".formatted(no,name);
    }
}
