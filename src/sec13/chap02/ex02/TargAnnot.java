package sec13.chap02.ex02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
public @interface TargAnnot {
    // 다른 어노테이션에 붙을 수 있는 타겟 어노테이션

}
