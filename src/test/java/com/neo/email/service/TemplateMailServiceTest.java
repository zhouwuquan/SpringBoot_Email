package com.neo.email.service;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * 模板邮件测试，其实就是HTML邮件
 * @author zhouwq
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateMailServiceTest {

	@Autowired
	private HtmlMailService htmlMailService;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Test
	public void htmlSendMailTest() throws MessagingException {
		
		Context context = new Context();
		context.setVariable("id", "006");
		
		String con = templateEngine.process("emailTemplate", context);
		htmlMailService.sendHtmlMail("173484695@qq.com", "java  发送的第一封模板测试邮件", con);
		System.out.println("邮件发送成功！！！");
	}
}
