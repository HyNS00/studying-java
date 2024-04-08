package sec13.chap02.ex02;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited // ⭐ 클래스에 사용될 시 자식 클래스도 이를 물려받음
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritT {
}
