package Yalco.sec10.chap04;
import java.util.*;

public class Ex02 {

    // 예외를 메소드 외부로 던지는 코드
    public static void main(String[] args) {
        Map<String,Integer> dutyRegMap = new HashMap<>();
        dutyRegMap.put("김현수", 3);
        dutyRegMap.put("김흠돌",23);

        dutyRegMap.forEach((name,month) -> {
            // 실행한 부분 혹은 호출한 곳에서 처리를 해줘야한다.
            try{
                registerDutyMonth(name,month);
            } catch (WrongMonthException we){
                we.printStackTrace();
                System.out.printf("%님 다시 설정해주세요", name);
            } catch(Exception e){
                e.printStackTrace();
            }
        });

    }
    public static void registerDutyMonth(String name, int month) throws WrongMonthException{
        if(month > 12 || month < 1){
            throw new WrongMonthException("옳바른 숫자를 입력해주세요");
        }
        System.out.printf("%s씨 %d월 담당으로 배정되셨어요%n", name, month);
    }
}
