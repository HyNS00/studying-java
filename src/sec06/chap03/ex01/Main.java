package sec06.chap03.ex01;

public class Main {
    public static void main(String[] args) {
        // 클래스가 클래스 필드인것 - 아래의 변수는 인스턴스
        Outer.InnerSttcMember staticMember = new Outer.InnerSttcMember();
        staticMember.func();

        System.out.println("\n----------------\n");

        Outer outer = new Outer();
        outer.innerFuncs();

        System.out.println("\n----------------\n");

        // 아래는 사용불가 - 객체 생성이 우선적으로 필요하다,
        //Outer.InnerInstMember innerInstMember = new outer.InnerInstMember();
        // 이렇게는 가능 Outer.InnerInstMember innerInstMember = outer.new InnerInstMember();

        // 인스턴스 내부 클래스는 이렇게 얻을 수 있다.
        Outer.InnerInstMember innerInstMember = outer.getInnerInstMember();
        innerInstMember.func();

        System.out.println("\n----------------\n");

        outer.memberFunc();

    }
}
