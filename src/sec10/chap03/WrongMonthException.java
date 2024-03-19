package sec10.chap03;
// RuntimeException을 계승한 사용자 정의 예외클래스
// WrongMonthException은 RuntimeException을 상속한 예외로 같은 종류의 예외문임을 명시한다.
public class WrongMonthException extends RuntimeException {
    //예외 클래스에서는 @Override 어노테이션을 사용하지 않는 것이 일반적입니다. 이는 예외 클래스에서 메서드를 재정의할 필요가 없기 때문입니다
    public WrongMonthException(int month){
        super(
                "제대로 된 숫자를 입력해주세요." +
                        "%d라는 숫자 해당하지 않습니다." +
                        "1 ~ 12사이의 숫자를 입력해주세요.".formatted(month)
        );
    }

}
