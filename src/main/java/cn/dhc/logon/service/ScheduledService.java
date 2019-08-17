package cn.dhc.logon.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-07-30
 */
@Service
public class ScheduledService {

    @Scheduled(fixedRate = 1000)
    public void printNowDate(){
        System.out.println(new Date());
    }

    /**
     * execute at 12:00 clock every day
     */
    @Scheduled(cron = "0 0 12 ? * *")
    public void printFormatTime(){
        Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        LocalDate localDate = LocalDate.now();
        System.out.println("instant:"+instant+"|localDate:"+localDate);
    }
}
