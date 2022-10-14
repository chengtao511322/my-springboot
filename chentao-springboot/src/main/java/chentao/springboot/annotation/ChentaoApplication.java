package chentao.springboot.annotation;


import chentao.springboot.autoconfig.AutoConfigurationSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@ComponentScan//扫描被该注解的类所在的包
@Import(AutoConfigurationSelector.class)
public @interface ChentaoApplication {
}
