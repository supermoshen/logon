package cn.dhc.logon.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
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
@Slf4j
public class ScheduledService {
    @Async
    @Scheduled(fixedRate = 10000)
    public void printNowDate() {
        log.info("Now Time is :" + new Date());
    }

    /**
     * execute at 12:00 clock every day
     */
    @Async
    @Scheduled(cron = "0 0 12 ? * *")
    public void printFormatTime() {
        Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        LocalDate localDate = LocalDate.now();
        log.info("instant:" + instant + "|localDate:" + localDate);
    }
}
