package cn.dhc.logon;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author : charles
 * @date : 2019/6/30 0030
 */
@SpringBootApplication
public class LogonApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(LogonApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
