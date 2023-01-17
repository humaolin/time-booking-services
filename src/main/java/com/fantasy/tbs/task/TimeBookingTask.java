package com.fantasy.tbs.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TimeBookingTask {


    @Scheduled(cron = "")
    public void scan() {
        // list all employee
        //scan time_booking table
        //get all employee for missing booking
        //send message to these employee
    }
}
