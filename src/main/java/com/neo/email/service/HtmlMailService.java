package com.neo.email.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * HTML形式发送邮件
 * @author zhouwq
 *
 */
@Service
public class HtmlMailService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendHtmlMail(String to, String subject, String context){
		try {
			log.info("发送HTML邮件开始:{},{},{}", to,subject,context);
				MimeMessage mmm = sender.createMimeMessage();//创建mime对象
				
				MimeMessageHelper helper = new MimeMessageHelper(mmm,true);
				helper.setTo(to);
				helper.setSubject(subject);
				helper.setText(context,true);
				helper.setFrom(from);
				
				sender.send(mmm);//发送HTML邮件
			log.info("发送HTML邮件成功!!!");
		}catch(MessagingException e) {
			log.error("发送HTML邮件异常:", e);
		}
	}

}
