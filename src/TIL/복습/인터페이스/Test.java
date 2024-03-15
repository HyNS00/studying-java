package TIL.복습.인터페이스;

public class Test implements Sample {
    @Override
    public int plus(int i, int j){
        return i + j;
    }

    @Override
    public int multiple(int i, int j){
        return i * j;
    }
}
