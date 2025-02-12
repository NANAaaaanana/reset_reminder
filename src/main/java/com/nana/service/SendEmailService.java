package com.nana.service;


import java.util.*;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import jakarta.annotation.Resource;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendEmailService {

    @Resource
    private JavaMailSender sender;

    @Value("${email.user}")
    private String user;

    @Value("${email.password}")
    private String password;

    private static final Logger LOGGER = Logger.getLogger(SendEmailService.class.getName());

    // 外部化配置，避免硬编码
    private static final String HOST = "smtp.gmail.com";  // SMTP 服务器地址

    // SMTP 配置
    private static final Properties properties = new Properties();

    static {
        // 初始化邮件会话的配置
        properties.setProperty("mail.smtp.host", HOST);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
    }

    /**
     * 发送邮件的方法
     *
     * @param subject       邮件主题
     * @param messageBody   邮件正文
     * @param recipientEmail 收件人邮箱
     */
    public void sendEmail(String subject, String messageBody, String recipientEmail) {
        // 验证发件人邮箱和密码是否设置
        if (user == null || password == null) {
            LOGGER.severe("邮箱用户名或密码未设置！");
            return;
        }


        try {
            // 创建 MimeMessage 对象
            final MimeMessage message = sender.createMimeMessage();
            final MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(user);
            helper.setTo(recipientEmail);
            helper.setSubject(subject);
            helper.setCc(user);
            helper.setText(messageBody, false);
            sender.send(message);
            LOGGER.info("邮件已成功发送到 " + recipientEmail);
        } catch (Exception e) {
            // 捕获邮件发送异常并记录日志
            LOGGER.log(Level.SEVERE, "邮件发送失败: ", e);
        }
    }

}
