package com.nana.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nana.service.SendEmailService;

import jakarta.annotation.Resource;

@Component
public class ReminderTask {

    @Resource
    private SendEmailService sendEmailService;

    @Value("${reminder.recipient.email}") // 默认 1 小时提醒一次（单位：秒）
    private String recipientEmail;

    // 11:00 AM - 休息提醒
    @Scheduled(cron = "0 0 11 * * ?")
    public void breakReminder() {
        sendEmailService.sendEmail("休息提醒", "11:00-11:15：较长时间休息（活动身体、放松眼睛）开始！", recipientEmail);
    }

    // 12:30 PM - 午餐和散步提醒
    @Scheduled(cron = "0 30 12 * * ?")
    public void lunchAndWalkReminder() {
        sendEmailService.sendEmail("午餐和散步提醒", "12:30-13:30：午餐 + 散步或轻度运动开始！", recipientEmail);
    }

    // 15:00 PM - 短暂休息提醒
    @Scheduled(cron = "0 0 15 * * ?")
    public void shortBreakReminder() {
        sendEmailService.sendEmail("短暂休息提醒", "15:00-15:10：短暂休息（活动身体、放松眼睛）开始！", recipientEmail);
    }

    // 17:00 PM - 短暂休息提醒
    @Scheduled(cron = "0 0 17 * * ?")
    public void finalShortBreakReminder() {
        sendEmailService.sendEmail("短暂休息提醒", "17:00-17:10：短暂休息（活动身体、放松眼睛）开始！", recipientEmail);
    }
}
