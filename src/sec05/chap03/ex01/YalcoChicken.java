package sec05.chap03.ex01;

public class YalcoChicken {
    // 클래스/ 정적 필드 : 본사의 정보와 기능
    // 인스턴스마다 따로 갖고 있을 필요가 없는 것들

    static String brand = "얄코치킨";
    static String contact(){
        // 정적메소드에서는 인스턴스 프로퍼티 불가

        return "%s입니다. 무엇을 도와드릴까요?".formatted(brand);
    }

    int no;
    String name;

    YalcoChicken(int no, String name){
        this.no = no;
        this.name = name;
    }

    String intro(){
        // 인스턴스 메소드에서는 정적 프로퍼티 사용가능
        return "안녕하세요, %s %d호 %s점 입니다."
                .formatted(brand,no,name);
    }
}
