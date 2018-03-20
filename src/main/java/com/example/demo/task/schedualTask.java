package com.example.demo.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Hao on 2018/3/16.
 */
@Configuration
@Component
@EnableScheduling
public class schedualTask {


    public void getCurrentTime(){
        System.out.println("Schedualing time is now: "+dataFormat().format(new Date()));
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void schedualing(){
        System.out.println("{} schedualTask schedualing ;Schedualing time is now : "+dataFormat().format(new Date()));
    }

    private SimpleDateFormat dataFormat(){
        return new SimpleDateFormat("HH:mm:ss");
    }

}
