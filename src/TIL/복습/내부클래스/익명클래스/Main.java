package TIL.복습.내부클래스.익명클래스;

public class Main {
    public static void main(String[] args) {
        Myclass my1 = new Myclass();
        my1.show(); // 일반 클래스

        // 일반 클래스의 확장
        Myclass test = new Myclass(){
            @Override
            public void show(){
                System.out.println("기존 클래스의 내용을 확장해보는 익명클래스");
            }
            // 내부에 메소드를 자체적으로 가질 수 있으나, 익명 클래스 외부로는 사용할 수 없다ㅋ.
        };
        test.show();
    }
}
