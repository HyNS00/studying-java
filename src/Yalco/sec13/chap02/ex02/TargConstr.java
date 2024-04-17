package Yalco.sec13.chap02.ex02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@TargAnnot
@Target(ElementType.CONSTRUCTOR)
public @interface TargConstr {
    // 생성자에 붙은 어노테이션
}
