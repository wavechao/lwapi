package com.wave.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wave.service.SelectionService;
import com.wave.service.UserService;

public class TestSelection {
	private SelectionService selectionService;
	
public SelectionService getSelectionService() {
		return selectionService;
	}

	public void setSelectionService(SelectionService selectionService) {
		this.selectionService = selectionService;
	}
	
	public TestSelection() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"beans.xml");
		 selectionService = (SelectionService) ac.getBean("selectionService");
	}
	public void test(){
		selectionService.getSelections();
	}
public static void main(String[] args) {
	TestSelection testSelection=new TestSelection();
	testSelection.test();
}
}
