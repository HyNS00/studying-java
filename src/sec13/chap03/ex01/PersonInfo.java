package sec13.chap03.ex01;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PersonInfo {
    // 다른 어노테이션을 필드로 가짐
    PersonNames personNames();
    int age();
    boolean married();
}
