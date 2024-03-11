package TIL.복습.내부클래스;

public class OuterClass {
    // 인스턴스 멤버 클래스
    class InstanceClass { // 내부 클래스는 static으로 해야 메모리 누수가 발생하지 않는다.

        int a;
        static int b;
        void method2(){
            System.out.println("인스턴스 클래스입니다.");
        }
    }
}
