package com.neo.email.service;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlMailServiceTest {

	@Autowired
	private HtmlMailService htmlMailService;
	
	@Test
	public void htmlSendMailTest() throws MessagingException {
		
		String context = "<html><body><h4>hello 这是我的第一封HTML邮件</h4></body></html>";
		htmlMailService.sendHtmlMail("173484695@qq.com", "java  发送的第一封HTML测试邮件", context);
	}
}
