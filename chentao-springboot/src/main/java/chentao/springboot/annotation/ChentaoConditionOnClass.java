package chentao.springboot.annotation;

import chentao.springboot.ChentaoConditon;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Conditional(ChentaoConditon.class)
public @interface ChentaoConditionOnClass {

    String value();
}
