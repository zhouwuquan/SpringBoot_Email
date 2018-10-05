package com.neo.email.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
/**
 * 简单文本邮件
 * @author zhouwq
 *2018-10-05
 */
@Service
public class TextMailService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Autowired
	private MailSender sender;
	
	public void sendTextMail(String to, String subject, String context) {
		log.info("发送邮件开始：{},{},{}", to, subject, context);
		try {
			SimpleMailMessage smm = new SimpleMailMessage();
			smm.setTo(to);
			smm.setSubject(subject);
			smm.setText(context);
			smm.setFrom(from);
			sender.send(smm);
			log.error("发送邮件成功");
		}catch(Exception e) {
			log.error("发送邮件异常：",e);
		}
	}

}
