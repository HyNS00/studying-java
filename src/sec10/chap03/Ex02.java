package sec10.chap03;

public class Ex02 {
    public static void main(String[] args) {
        registerDutyMonth("김현수",3);

        registerDutyMonth("김흠돌",33);
    }
    public static void registerDutyMonth (String name,int month){
        if (month > 12 || month < 1){
            throw new IndexOutOfBoundsException(
                    "월은 1월부터 12월까지만 존재합니다"
            );
        }
        System.out.printf("%d월 담당자는 %s입니다.%n", month, name);
    }
}
