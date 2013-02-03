package com.wave.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wave.service.UserService;

public class Test {
public static void main(String[] args) {
	ApplicationContext ac = new ClassPathXmlApplicationContext(
			"beans.xml");
	UserService service = (UserService) ac.getBean("userService");
	System.out.println(service.findAllUser().get(0).getScreenname());
}
}
