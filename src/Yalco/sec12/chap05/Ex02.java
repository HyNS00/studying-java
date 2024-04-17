package Yalco.sec12.chap05;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import static Yalco.sec12.chap05.Main.PEOPLE_PATH;

public class Ex02 {
    public static void main(String[] args) {
        Person person1Out;
        Person person2Out;
        List<Person> peopleOut;

        //  ⭐️ 다시 인스턴스로 역직렬화
        try (
                FileInputStream fis = new FileInputStream(PEOPLE_PATH);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
        ) {

            //  ⚠️ 직렬화할 때와 순서 동일해야 함
            //  - 순서 바꾸고 재실행 해 볼 것
            person1Out = (Person) ois.readObject();
            person2Out = (Person) ois.readObject();
            peopleOut = (ArrayList) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(person1Out);
        System.out.println(person2Out);
        System.out.println(peopleOut);
    }

    //serialVersionUID : 직렬화하여 주고받을 클래스의 버전
    /* - 직접 지정하지 않으면 자동으로 생성됨
- 클래스를 보낼 쪽과 받을 쪽에 명시된 클래스의 내용이 다를 때를 대비
- 직렬화 한 뒤(`☕ [Ex01.java](http://Ex02.java)` 실행) 경우들을 테스트(`☕ [Ex02.java](http://Ex02.java)` 실행)
    - `Person` 클래스의 내용은 유지하되 버전 번호를 바꿀 것
        - ⚠️예외 발생 *( 클래스 변경내용이 공유되어야 함을 받는 쪽에 알림 )*
    - 버전 번호를 유지하되, `Person` 클래스 `name` 필드의 이름을 변경
        - 예외는 발생하지 않으나 해당 필드 값이 `null`으로 - ☢️ 위험상황!
    - 버전 번호를 유지하되, `Person` 클래스 `age` 필드의 타입을 변경
        - ⚠️예외 발생

     */
}
