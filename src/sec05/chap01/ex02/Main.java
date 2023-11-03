package sec05.chap01.ex02;

public class Main {
    public static void main(String[] args) {
        YalcoChicken store1 = new YalcoChicken(); // 새 인스턴스 생성
        store1.no = 3; // 그 인스턴스의 필드에 접근 매장 순위
        store1.name = "판교"; // store1은 YalcoChicken이란 클래스의 인스턴스
        // 그 클래스 필드의 이름에 접근

        YalcoChicken store2 = new YalcoChicken();
        store2.no = 17;
        store2.name = "강남";

        // 인스턴스의 필드들에 접근
        int store1No = store1.no;
        String store2Name = store2.name;

        // 인스턴스의 메소드 호출
        String store1Intro = store1.intro();
        String store2Intro = store2.intro();


    }
}
