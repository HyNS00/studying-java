package Yalco.sec13.chap01.ex01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.*;
// 모든 예외는 본문에서 던지겠다. 코드의 간편함을 위해
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //  💡 클래스를 가져오는 두 방법
        //  - 와일드카드<?> 사용 가능

        Class<Button> btnClass1 = Button.class;
        //  예외 던짐 : ClassNotFoundException -> 없을 수도 있기 때문에 try-catch
        Class<?> btnClass2 = Class.forName("Yalco.sec13.chap01.ex01.Button");

        boolean areSame = btnClass2 == btnClass1;

        //  💡 모든 생성자 배열로 가져오기
        Constructor[] btn1Constrs = btnClass1.getConstructors();

        // 💡 생성자 가져오기
        //  - 주어진 인자 타입에 일치하는 것으로
        //  - 일치하는 것 없을 시 예외 던짐 : NoSuchMethodException
        Constructor<?> btn1Constr = btnClass1.getConstructor(String.class,int.class);

        //  💡 생성자 사용하기
        //  - 예외 던짐 : IllegalAccessException
        Button button1A = (Button) btn1Constr.newInstance("Enter",3);
        // 인스턴스를 만듦(newInstance)
        //  각각에 맞는 인자들 넣어야 정상동작
        Button button1B = (Button)  btn1Constrs[0].newInstance();
        Button button1C = (Button)  btn1Constrs[1].newInstance("Tab", 2);

        //  💡 필드들 가져오기
        //  - 각 항목 펼쳐서 확인해 볼 것
        Field[] btnFields = btnClass1.getDeclaredFields();
        for (Field f : btnFields) {
            System.out.printf(
                    "변수명: %s\n타입: %s\n선언된 클래스: %s\n\n",
                    f.getName(),
                    f.getType(),
                    f.getDeclaringClass()
            );
        }

        //  💡 특정 필드 이름으로 가져오기
        //  - 예외 던짐 : NoSuchFieldException
        //  - public 필드만 가능
        Field btn1Disabled = btnClass1.getField("disabled");
        //Field btnSpaces = btnClass1.getField("spaces"); //

        System.out.println("\n- - - - -\n");

        //  💡 메소드들 가져오기
        //  - 각 항목 펼쳐서 확인해 볼 것

        Method[] btnMethods = btnClass1.getDeclaredMethods();
        for(Method m : btnMethods){
            System.out.printf(
                    "메소드명: %s\n인자 타입(들): %s\n반환 타입: %s\n\n",
                    m.getName(),
                    Arrays.stream(m.getParameterTypes())
                            .map(Class::getSimpleName)
                            .collect(Collectors.joining(", ")),
                    m.getReturnType()
            );
        }

        System.out.println("\n- - - - -\n");

        //  ️⭐ Button 식별자를 코드에서 못 쓰는 상황 가정
        //  - 어떤 클래스가 들어올 지 모르는 상황 등...
        Object button2 = btnClass2.getConstructor(String.class, int.class)
                .newInstance("Space",5);

        Field btn2Disabled = btnClass2.getField("disabled");

        //  💡 특정 인스턴스의 필드 값 얻기
        boolean btn2DisabledVal = (boolean) btn2Disabled.get(button2);
        //  💡 필드 값 변경
        btn2Disabled.set(button2, true);

        // 필드 배열로 접근시
        for(Field f : btnClass2.getDeclaredFields()){
            f.setAccessible(true); // private한 필드에도 접근하기 위함
            System.out.println(f.getName() + " : " + f.get(button2));
        }

        System.out.println("\n- - - - -\n");
        Method btn2onClick = btnClass2.getMethod("onClick", boolean.class, int.class, int.class);
        // 메소드 찾음
        btn2onClick.invoke(button2,false,123,455);
        // 메소드 호출
        System.out.println("\n- - - - -\n");

        //  💡 상위 클래스와 인터페이스들 가져오기
        Class<?> btn1Super = btnClass1.getSuperclass(); // 부모는 하나만 존재
        Class[] btn1Interfaces = btnClass1.getInterfaces(); // 인터페이스는 여럿 존재
    }
}
