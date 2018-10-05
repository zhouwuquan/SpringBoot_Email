package com.neo.email.service;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttachmentslMailServiceTest {

	@Autowired
	private AttachmentsMailService attachmentsMailService;
	
	@Test
	public void AttachmentsSendMailTest() throws MessagingException {
		String filePath = "D:\\sts-bundle\\workspace-sts\\SpringBoot_Email\\springboot_email.docx";
		
		attachmentsMailService.sendAttachmentsMail("17602120842@163.com", "boot附件测试邮件", "这是一封带附件", filePath);
	}
}
