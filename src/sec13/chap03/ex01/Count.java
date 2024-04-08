package sec13.chap03.ex01;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Count {

    // int value();  기본값이 없을 때
    int value() default 1; // 기본값 설정
}
