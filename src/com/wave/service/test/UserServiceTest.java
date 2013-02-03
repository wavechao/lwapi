package com.wave.service.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wave.model.User;
import com.wave.service.UserService;

public class UserServiceTest {
	UserService service;

	public UserServiceTest() {
		// TODO Auto-generated constructor stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		service = (UserService) ac.getBean("userService");
	}

	public void login() {
		User user = service.login("wave", "1234");
		System.out.println("user==null:" + (user == null));
		System.out.println("username:" + user.getUsername() + "email:"
				+ user.getEmail());
	}

	public void add() {
		User user = new User();
		user.setUsername("1d3");
		user.setPassword("12345");
		// user.setScreenname("dsfs");
		// user.setDeptid(1);
		// user.setMajorid(1);
		user.setGender((byte) 0);
		user.setLevel((byte) 10);
		User userFrom = service.addUser(user);
		System.out.println("name:" + userFrom.getUsername() + ",gender:"
				+ userFrom.getGender());
	}

	public void update() {
		User user = new User();
		// user.setUsername("12ewfs3");
		user.setScreenname("Ë®ÊÖ");
		// user.setDepartment(1);
		// user.setMajor(1);
		// user.setGender((byte) 0);
		user.setLevel((byte) 0);
		user.setEmail("");
		user.setUserid(1);
		service.updateUser(user);
	}

	public void test() {
		User user = new User();
		user.setUserid(1);
		user.setAvatar("http://baidu.com");
		user.setAvatar_thumb("http://baidu.com");
		service.updateUserPicUrl(user);
	}

	public void findbyId() {
		User user = service.findUser(1);
		System.out.println("name:" + user.getUsername());
	}

	public void getTeachers() {
		List<User> users = service.getTeacher(1, 20, 1);
		for (User user : users) {
			System.out.println("username:" + user.getUsername()
					+ ",screenname:" + user.getScreenname());
		}
	}

	public void queryAll() {
		List<User> users = service.findAllUser();
		for (User user : users) {
			System.out.println("name:" + user.getUsername());
		}
	}

	public void levelup() {
		service.levelup("1,2");
	}

	public void myTest() {
		// int depart_id,int major_id,int count,int page,int level
//		 List<User>users=service.getUser(1, 1, 8, 1, 10);
//		 List<User>users=service.getUserBiggerLevel(0, 1,5, 1, 10,50);
		List<User> users = service.getUserLittlerLevel(0, 1, 5, 0, 50);
		for (User user : users) {
			System.out.println("username:" + user.getUsername());
		}
	}
	public void levelupTeacher(){
		String string="1,2,3,4";
		service.levelup(string);
		
	}

	public static void main(String[] args) {
		new UserServiceTest().myTest();
	}
}
