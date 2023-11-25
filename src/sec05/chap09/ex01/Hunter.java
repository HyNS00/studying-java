package sec05.chap09.ex01;

public interface Hunter {
    String position = "포식자"; // 인터페이스의 필드는 무조건 final
    // 따라서 초기화와 선언을 같이 해줘야한다.

    void hunt(); // 추상 메소드 가능
}
