package com.schedule.time;

import com.common.util.UtilDao;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class TestTimer {

    //  每三秒执行一次
    @Scheduled(cron="0/3 * * * * ?")
    private void test() {
        System.out.println("执行定时任务的时间是：" + UtilDao.getCurrentDateString());
    }


    @Scheduled(cron="0/6 * * * * ?")
    private void test2() {
        System.out.println("****执行定时任务的时间是：" + UtilDao.getCurrentDateString());
    }

}