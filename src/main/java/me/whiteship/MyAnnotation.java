package me.whiteship;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 보통 애노테이션은 클래스 파일을 로딩 했을때 읽어오지 않는다 그래서 런타임까지 유지하기 위해
// 위와 같이 설정해줘야한다.
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface MyAnnotation {

    String name() default "hangjin";
    int number() default 100;
}
