package Yalco.sec06.chap01;

public class Ex04 {
    public static void main(String[] args) {
//        new Ex04().printKings(); // 객체 생성
        // 이게 더 올바른 표현
        Ex04 ex = new Ex04();
        ex.printKings();
    }
    String king = "김현수";
    void printKings(){
        String king = "여우";
        System.out.printf("인스턴스의 왕은 %s, 블록의 왕은 %s%n",
                king, this.king);
    }

    // this.king = 사자  : 인스턴스의 필드 king을 참고
    // king = 여우 : 메소드 안에 있는 king을 참고
}