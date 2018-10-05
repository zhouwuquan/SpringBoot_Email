package com.neo.email.service;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InlineServiceTest {

	@Autowired
	private com.neo.email.service.sendInlineMailService sendInlineMailService;
	
	@Test
	public void InlineSendMailTest() throws MessagingException {
		//图片一
		String rscId = "zhou001";
		String filePath = "D:\\sts-bundle\\workspace-sts\\SpringBoot_Email\\one.jpg";
		
		//图片一
		String rscId2 = "zhou002";
		String filePath2 = "D:\\sts-bundle\\workspace-sts\\SpringBoot_Email\\two.jpg";
		
		String context = "<html><body>这里有图片1的邮件:<img src=\'cid:"+rscId+"\'></img>"
				+ "这里有图片2的邮件:<img src=\'cid:"+rscId2+"\'></img></body></html>";
		
		sendInlineMailService.sendInlineMail("173484695@qq.com", "java  发送的第一封带内容图片测试邮件",context,rscId ,filePath,rscId2,filePath2);
	}
}
