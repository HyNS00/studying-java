package sec13.chap02.ex02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RetRunTime {
    // 실행시에 사용가능
}
