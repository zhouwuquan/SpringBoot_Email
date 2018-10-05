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
 * 发带附件的邮件
 * @author zhouwq
 *
 */
@Service
public class AttachmentsMailService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendAttachmentsMail(String to, String subject, String context, String filePath){
		try {
			log.info("发送附件邮件开始：{},{},{},{}", to,subject,context,filePath);
			MimeMessage mmm = sender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mmm,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(context,true);
			
			FileSystemResource file = new FileSystemResource(new File(filePath));
			String fileName = file.getFilename();
			helper.addAttachment(fileName, file);
			//helper.addAttachment(fileName+"test", file);//支持批量发送
			
			sender.send(mmm);//发送HTML邮件
			log.info("发送附件邮件成功！！！");
		}catch(MessagingException e) {
			log.error("发送附件邮件异常：", e);
		}
	}

}
