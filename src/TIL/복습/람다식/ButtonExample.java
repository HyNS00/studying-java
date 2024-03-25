package TIL.복습.람다식;

public class ButtonExample {
    public static void main(String[] args) {
        Button btnOk = new Button();

        Button.ClickListener mi = new Button.ClickListener(){
            @Override
            public void onClick(){
                System.out.println("Ok 버튼을 클릭");
            }
        };

        Button.ClickListener mi2 = () -> System.out.println("Ok 버튼을 클릭");

        btnOk.setClickListener(mi2);
        btnOk.setClickListener(() -> {
            System.out.println("Ok 버튼을 클릭");
        });

        btnOk.click();
    }
}
