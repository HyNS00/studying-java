package Yalco.sec13.chap02.ex02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
//@Retention은 어노테이션의 유지 정책을 지정하기 위한 메타어노테이션(Meta Annotation)
//  즉, 어노테이션을 정의할 때 이 어노테이션이 얼마나 오랫동안 유지되어야 하는지를 결정

@Retention(RetentionPolicy.SOURCE)
public @interface RetSource {
    // 어노테이션이 유지되는 범위
    // SOURCE -> 소스 파일에만 적용

}
