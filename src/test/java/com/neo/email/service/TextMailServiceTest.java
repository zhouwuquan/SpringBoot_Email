package com.neo.email.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TextMailServiceTest {

	@Autowired
	private TextMailService textMailService;
	
	@Test
	public void textSendMailTest() {
		textMailService.sendTextMail("173484695@qq.com", "java  发送的第一封测试邮件", "hi  springboot  mail");
	}
}
