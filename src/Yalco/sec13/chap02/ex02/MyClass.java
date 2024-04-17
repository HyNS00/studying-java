package Yalco.sec13.chap02.ex02;


import java.lang.reflect.Field;
import java.util.Arrays;
import java.lang.annotation.*;
import java.util.stream.*;

@InheritF
@InheritT
public class MyClass {
    @RetClass
    int retClass;

    @RetRunTime
    int retRunTime;

    @RetSource
    int retSource;
    // 소스코드까지만 유지하기 때문에 컴파일한 다음엔
    // 어노테이션이 뜨지 않음

    @TargConstr
    public MyClass(){
    }

    @TargField
    @TargMulti
    int targField;

    @TargMulti
    public void targMethod () {}

    @TargMulti
    boolean targMulti = true;
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> myClass = Class.forName("Yalco.sec13.chap02.ex02.MyClass");
        for (Field f : myClass.getDeclaredFields()) {
            if (f.getAnnotations().length > 0) {
                System.out.printf(
                        "%s : %s%n",
                        f.getName(),
                        Arrays.stream(f.getAnnotations())
                                .map(Annotation::toString)
                                .collect(Collectors.joining(","))
                );
            }
        }

        System.out.println("\n- - - - -\n");

        Class<?> mySubclass = Class.forName("Yalco.sec13.chap02.ex02.MySubclass");
        System.out.println(
                "MySubclass의 어노테이션 : " +
                        Arrays.stream(mySubclass
                                        .getAnnotations())
                                .map(Annotation::toString)
                                .collect(Collectors.joining(","))
        );

        @RepeatF(a = 1, b = 2)
        //@RepeatF(a = 3, b = 4) // ⚠️ 반복 불가

        @RepeatT(a = 1, b = 2)
        @RepeatT(a = 3, b = 4)
        @RepeatT(a = 5, b = 6)
        boolean repeat;
    }

}
