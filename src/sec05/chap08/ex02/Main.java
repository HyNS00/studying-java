package sec05.chap08.ex02;

public class Main {
    public static void main(String[] args) {
        Button button1 = new Button(2,"ENTER");
        Switch switch1 = new Switch(3,true);
//        DropDown dropDown1 = new DropDown(5, new String[] {
//                "이름 오름 차순", "이름 내림 차순",
//                "크기 오름 차순", "크기 내림 차순",
//                "날짜 오름 차순", "날짜 내림 차순"
//        });
        // 여기서는 배열이 존재하지 않기 때문에 새로 만들어야했으므로 new String []을 통해 선언했다
        // 아래가 좀 더 좋은 코드
        String[] options = {  "이름 오름 차순", "이름 내림 차순",
                "크기 오름 차순", "크기 내림 차순",
                "날짜 오름 차순", "날짜 내림 차순"};
        DropDown dropDown1 = new DropDown(5,options);
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
