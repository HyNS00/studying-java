package sec10.chap03;

public class Ex04 {
    public static void main(String[] args) {
        try{
            registerMonth("김돌준",13);
        } catch(WrongMonthException w){
            w.printStackTrace();
        }
    }
    public static void registerMonth(String name, int month){
        if(month > 12 || month < 1){
            throw new WrongMonthException(month);
        }
        System.out.printf("%s가  %d월의 담당입니다.",name, month);
    }
}
