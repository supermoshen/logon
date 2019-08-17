package cn.dhc.logon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-07-30
 */
@Configuration
@ComponentScan("cn.dhc.logon.service")
@EnableScheduling
public class SchedulerConfig {
}
