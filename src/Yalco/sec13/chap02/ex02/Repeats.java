package Yalco.sec13.chap02.ex02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Repeats {
    RepeatT[] value();
}
