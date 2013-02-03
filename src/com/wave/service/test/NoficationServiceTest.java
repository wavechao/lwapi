package com.wave.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wave.model.Notification;
import com.wave.service.NotificationService;
import com.wave.service.UserService;

public class NoficationServiceTest {
	NotificationService service;

	public NoficationServiceTest() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		service = (NotificationService) ac.getBean("notificationService");
	}
	
	public void add(){
		Notification notification=service.addNotificationForDepartment("±êÌâ", "ÄÚÈÝ", 1, 10,"");
		System.out.println(notification.getContent());
	}
	public static void main(String[] args) {
		new NoficationServiceTest().add();
	}
}
