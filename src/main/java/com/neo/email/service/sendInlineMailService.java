package com.neo.email.service;

import java.io.File;
import java.nio.file.FileSystem;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
/**
 * 带图片的邮件发送
 * @author zhouwq
 *
 */
@Service
public class sendInlineMailService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendInlineMail(String to, String subject, String context, String rscId,String rscPath,String rscId2,String rscPath2){
		try {
			log.info("发送带图片邮件开始：{},{},{},{},{},{},{}", to,subject,context,rscId,rscPath,rscId2,rscPath2);
			MimeMessage mmm = sender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mmm,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(context,true);
			
			//图片一
			FileSystemResource file = new FileSystemResource(new File(rscPath));
			helper.addInline(rscId, file);
			
			//图片二
			FileSystemResource file2 = new FileSystemResource(new File(rscPath2));
			helper.addInline(rscId2,file2);
			
			
			sender.send(mmm);//发送HTML邮件
			log.info("发送带图片的邮件成功！！！");
		}catch(MessagingException e) {
			log.error("发送带图片邮件失败:", e);
		}
	}

}
