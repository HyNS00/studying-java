package sec05.chap01.ex02;

public class YalcoChicken {
    // 인스턴스가 가질 필드
    // 정보
    int no;
    String name;

    // 인스턴스가 가질 메소드 - static을 붙이지 않는다
    // 실행할 수 있음
    String intro() {
        return "안녕하세요, %d호 %s점 입니다.".formatted(no,name);
    }

}
