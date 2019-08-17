package cn.dhc.logon.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-07-30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface ConfigurationAndComponentScan {
    String [] value() default {};
}
