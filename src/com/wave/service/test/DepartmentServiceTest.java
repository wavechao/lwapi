package com.wave.service.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wave.model.Department;
import com.wave.model.Major;
import com.wave.service.DepartmentsService;
import com.wave.service.MajorService;

public class DepartmentServiceTest {
	DepartmentsService service;
	MajorService majorService;

	public DepartmentServiceTest() {
		// TODO Auto-generated constructor stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		service = (DepartmentsService) ac.getBean("departmentService");
		majorService = (MajorService) ac.getBean("majorService");
	}

	public void show() {
		Department d = service.queryDepartmentsById(1);
		System.out.println("name--->" + d.getName());
		// List<Department>departments=service.queryAllDepartments();
		// for(Department department :departments){
		// System.out.println("name--->"+department.getName());
		// List<Major>majors=department.getMajors();
		// for(Major major:majors){
		// System.out.println("major -->"+major.getName());
		// }
		// }
	}

	public void add() {
		Department department = service.addDepartment("工管系", 0);
		System.out.println("department==null?" + (department == null));
		System.out.println("name:" + department.getName());
	}

	public void addMajor() {
		Major major = new Major();
		major.setDeptid(1);
		major.setName("电子");
		 Major m=majorService.addMajor(major);
//		Major m = majorService.queryMajorById(11);
		System.out.println("id:" + m.getDepartment().getDeptid());
	}

	public static void main(String[] args) {
		new DepartmentServiceTest().addMajor();
	}
}
