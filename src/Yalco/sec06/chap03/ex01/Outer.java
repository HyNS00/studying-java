package Yalco.sec06.chap03.ex01;

public class Outer {
    private String inst = "인스턴스";
    private static String sttc = "클래스";

    // 멤버 인스턴스 클래스
    class InnerInstMember {
        // 외부 클래스의 필드와 클래스 접근가능
        private String name = inst + "필드로서의 클래스";
        private InnerSttcMember innerSttcMember = new InnerSttcMember();

        public void func (){
            System.out.println(name);
        }
    }

    // 정적 내부 클래스
    // 내부 클래스에도 접근자는 사용가능하다
    public static class InnerSttcMember{
        // 외부 클래스의 클래스 필드만 접근이 가능
        private String name  = sttc + "필드로서의 클래스";

        // static이 아닌 멤버 인스턴스에는 접근이 불가능하다
//        private InnerInstMember innerInstMember = new InnerInstMember();

        public void func() {
            // 인스턴스 메소드지만 클래스가 정적이므로 인스턴스 필드 접근 불가
            // name += inst;
            System.out.println(name);
        }
    }

    public void memberFunc(){
        // 메소드 안에 정의된 클래스
        // 스코프가 메소드 내로 제한된다.
        class MethodMember {
            // 외부의 필드와 클래스에 접근은 가능
            String instSttc = inst + " " + sttc;
            InnerInstMember innerInstMember = new InnerInstMember();
            InnerSttcMember innerSttcMember = new InnerSttcMember();


            public void func() {
                innerInstMember.func();
                innerSttcMember.func();
                System.out.println("메소드 안의 클래스");
            }
        }
        new MethodMember().func();
    }
    public void innerFuncs(){
        new InnerInstMember().func();
        new InnerSttcMember().func();
    }
    public InnerInstMember getInnerInstMember() {
        return new InnerInstMember();
    }
}
