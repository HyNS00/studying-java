package sec09.chap03;

public class Button {
    private String text;
    private Runnable onClickListener;

    public Button(String text){
        this.text = text;
    }

    public Button(String text, String sound){
        this(text); // text만을 인자를 가지는 생성자 호출
        onClickListener = () -> System.out.println(sound + " " + sound);

    }

    public String getText() {
        return text;
    }

    public void setOnClickListener(Runnable onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void onClick(){
        onClickListener.run();
    }
}
