package sec05.chap08.ex02;

public class Main {
    public static void main(String[] args) {
        Button button1 = new Button(2,"ENTER");
        Switch switch1 = new Switch(3,true);
        DropDown dropDown1 = new DropDown(5, new String[] {
                "이름 오름 차순", "이름 내림 차순",
                "크기 오름 차순", "크기 내림 차순",
                "날짜 오름 차순", "날짜 내림 차순"
        });

        //  💡 다형성 적용 확인
        clickFormElement(button1);

        clickFormElement(switch1);
        clickFormElement(switch1);
        clickFormElement(switch1);

        clickFormElement(dropDown1);
    }
    public static void clickFormElement (FormElement fe){
        fe.func();
    }
}
