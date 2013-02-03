package com.wave.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wave.service.TitleService;
import com.wave.service.UserService;

public class TestTitleService {
	private TitleService titleService;

	public TitleService getTitleService() {
		return titleService;
	}

	public void setTitleService(TitleService titleService) {
		this.titleService = titleService;
	}

	public TestTitleService() {

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		titleService = (TitleService) ac.getBean("titleService");
	}
	public void test(){
//		titleService.getTitles();
//		titleService.getMyTitle(1, 20, 1);
		titleService.plus(1);
	}

	public static void main(String[] args) {
		TestTitleService testTitleService=new TestTitleService();
		testTitleService.test();
	}
}
