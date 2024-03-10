package TIL.복습.클래스와변수;

public class Engine {
    private String type;

    public Engine(String type){
        this.type = type;
    }

    public String start(){
        return "The "  + type + " engine is running";
    }


}
