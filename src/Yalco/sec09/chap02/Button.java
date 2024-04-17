package Yalco.sec09.chap02;

public class Button {
    private String text;

    public Button(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    private Runnable onClickListenr;
    public void setOnClickListenr(Runnable onClickListenr){
        this.onClickListenr = onClickListenr;
    }

    public void onClick(){
        onClickListenr.run();
    }
}
