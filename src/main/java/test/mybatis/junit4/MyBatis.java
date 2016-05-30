package test.mybatis.junit4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MyBatis {

    String resource() default "mybatis.xml";

    boolean openSession() default true;

    boolean autoCommit() default true;

}
