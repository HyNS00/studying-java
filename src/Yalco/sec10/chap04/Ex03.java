package Yalco.sec10.chap04;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Ex03 {
    // 예외 되던지기
    // 메소드와 호출부 모두에서 예외를 처리
    // 메소드에서는 예외처리를 한 뒤에 이를 다시 던진다
    
    public static void main(String[] args) {
        Map<String, Integer> dutyRegMap = new HashMap<>();
        dutyRegMap.put("정핫훈", 7);
        dutyRegMap.put("김돌준", 13);
        dutyRegMap.forEach((name, month) -> {
            try{
                registerDutyMonthSafer(name,month);
            } catch(WrongMonthException we){
                we.printStackTrace();
                System.out.println("오류를 한번 감지");
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }
    // 자기 선에서도 예외를 처리하고, 외부로도 던짐
    // 예외를 양쪽에서 처리를 할 필요가 있을 경우

    public static void registerDutyMonthSafer (String name, int month) throws WrongMonthException{
        try{
            if (month > 12 || month < 1){
                throw new WrongMonthException(
                        "일단은 랜덤으로 배정하겠습니다"
                );
            }
            System.out.printf("%s님은 %d월로 배정되었습니다%n",name,month);
        } catch (WrongMonthException we){
            System.out.printf("%s님은 임시적으로 %d월로 배정되었습니다%n",
                    name,new Random().nextInt(1,12+1));
            throw we; // 다시 예외를 던짐
        }
    }
}
