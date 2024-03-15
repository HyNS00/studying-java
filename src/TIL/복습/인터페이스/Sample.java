package TIL.복습.인터페이스;

public interface Sample {

    public int plus(int i, int j);
    public int multiple(int i,int j);

    // private 메소드 -> 자바 9에서 추가한 내용
    private void printf(){
        System.out.println("private 메서드는 default 내부에서만 호출이 가능합니다.");
    }

    // private 스태틱 메소드
    private static void printfStatic(){
        System.out.println("private static 메서드는 static메서드 내부에서만 호출이 가능합니다.");
    }

    // 디폴트 메서드 -> 자바 8에서 추가된 내용
    // default가 붙어야함 -> 인터페이스를 모두 구현한 구현체에게 수정없이 광역으로 해주고 싶을 때 사용
    default void callPrivate(){
        printf(); // private메서드 호출
    }

    // static 메서드
    static void callPrivateStatic(){
        printfStatic();
    }

}
