package com.imooc.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.text.SimpleDateFormat;

@Component
public class TestTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    // 定义每过3秒执行任务
   //@Scheduled(fixedRate = 3000)
   //cron表达式：http://cron.qqe2.com/
	//@Scheduled(cron = "1-30 * * * * ? ")
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
