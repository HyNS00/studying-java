package Yalco.sec05.chap06.ex00;

public class Main {
    public static void main(String[] args) {
        // 가능 - 자식 클래스는 부모 클래스에 속함
        Button button1 = new Button("Enter");
        Button button2 = new ShutDownButton();
        Button button3 = new ToggleButton("CapsLock",true);


        // 불가
        // 부모 클래스를 자식 클래스에 넣는 것은 불가능
//        ShutDownButton button4 = new Button("Enter");
//        ToggleButton button5 = new ShutDownButton();

        // 모든 자식 클래스는 부모 클래스에 해당하기 때문에
        // 아래와 같은 것이 가능하다
//        Button[] buttons = {
//                new Button("Space"),
//                new ToggleButton("NumLock",false),
//                new ShutDownButton()
//        };
//        for (Button button : buttons){
//            // 모든 Button들은 func메소드를 가지고 있다.
//            button.func();
//        }
        // 다형성 - 특정 자료형 자리에 여러 종류가 들어 올 수 있는 것

        // instanceof - 뒤에 오는 클래스의 자료형에 속하는 인스턴스인지 확인
        // 상속관계가 아닌 클래스끼리는 컴파일 오류

        Button button = new Button("버튼");
        ToggleButton toggleButton = new ToggleButton("토글", true);
        ShutDownButton shutDownButton = new ShutDownButton();

        // true
        boolean typeCheck1 = button instanceof Button;
        boolean typeCheck2 = toggleButton instanceof Button;
        boolean typeCheck3 = shutDownButton instanceof Button;
        // 버튼 외에도 토글버튼, 셧다운 버튼은 버튼의 자손이므로 항상 인스턴스에 속한다.

        //  false
        boolean typeCheck4 = button instanceof ShutDownButton;
        boolean typeCheck5 = button instanceof ToggleButton;
        // 버튼의 인스턴스 즉 버튼의 클래스가 셧다운 버튼, 토글 버튼의 부모이므로 속하지 않는다.

        //  ⚠️ 컴파일 에러
        //        boolean typeCheck6 = toggleButton instanceof ShutDownButton;
        //        boolean typeCheck7 = shutDownButton instanceof ToggleButton;
        // 토글 버튼과 셧다운 버튼은 둘 다 버튼의 자식인거지 둘의 관계는 아무 상관이 없으므로 컴파일 에러

        // 활용
        Button[] buttons = {
                new Button("Space"),
                new ToggleButton("NumLock", false),
                new ShutDownButton()
        };

        for (Button btn : buttons){
            if (btn instanceof ShutDownButton){
                continue;
            }
            btn.func();
        }
    }

}
