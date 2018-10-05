package com.neo.email.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldServiceTest {
	
	@Resource
	private HelloWorldService helloWorldService;
	
	@Test
	public void sayHelloTest() {
		String msg = helloWorldService.sayHello();
		System.out.println("msg"+msg);
	}

}
