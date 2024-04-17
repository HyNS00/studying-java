package Yalco.sec13.chap05;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 메소드 정수 인자의 최소/최대값
 */
@Documented
@Target(ElementType.METHOD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface MinMax {
    int min() default 0;
    int max() default 10;
}

/*
- `[Student.java](http://Student.java)` 의 `getClassFromPeriod` 메소드에 아래 추가
    - `@MinMax(min = 1, max = 5)`
- `@Documented` : 해당 어노테이션이 사용되는 곳의 문서에 어노테이션 정보 표시
 */