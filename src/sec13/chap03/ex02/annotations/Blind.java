package sec13.chap03.ex02.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // 필드에 쓰일 수 있는 어노테이션
@Retention(RetentionPolicy.RUNTIME)
public @interface Blind {
}
