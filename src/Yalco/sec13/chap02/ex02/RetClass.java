package Yalco.sec13.chap02.ex02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface RetClass {

    // 클래스파일까지 적용
    // 실행시에는 사용 불가

}
