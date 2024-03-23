package sec10.chap04;

// chained exception 연결된 예외 -> 특정 예외가 발생할 때 이를 원인으로 하는 다른 예외를 던짐
import java.util.*;

public class Ex05 {
    public static void main(String[] args) {
      Map<String,Integer> dutyRegMap = new HashMap<>();
      dutyRegMap.put("정핫훈",3);
      dutyRegMap.put("김흠돌",8);

      dutyRegMap.forEach((name,month) -> {
          try{
              chooseDutyMonth(name, month);
          } catch (WrongMonthException we){
              we.printStackTrace();
              System.out.printf("%s님 잘못 입력하셨어요", name);
          } catch (Exception e){
              e.printStackTrace();
          }
      });
    }

    public static void chooseDutyMonth (String name, int index) throws WrongMonthException{
        int[] availables = {1,3,4,7,9,12};

        try{
            int month = availables[index -1];
            System.out.printf("%님은 %월 담당입니다.%n",name, month);
        } catch (ArrayIndexOutOfBoundsException ae){
            WrongMonthException we = new WrongMonthException(
                    "%d는 없습니다.".formatted(index)
            );

            // 예외의 원인이 되는 예외를 지정한다 -> 수행하는 생성자가 없을 경우
            we.initCause(ae);
            throw we;
        }
    }
}
