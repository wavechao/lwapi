package com.wave.action.department;

import java.io.IOException;

import com.wave.action.BasicAciton;
import com.wave.model.Department;
import com.wave.model.User;
import com.wave.service.DepartmentsService;
import com.wave.service.UserService;
import com.wave.util.KvdbUtil;
import com.wave.util.Util;

public class CreateAction extends BasicAciton {
	private String name;
	private int directorid=0;
	private DepartmentsService departmentService;
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDirectorid(int directorid) {
		this.directorid = directorid;
	}

	public void setDepartmentService(DepartmentsService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public String execute() {

		if (Util.isNull(name)) {
			setErrorCode(400,"参数name错误");
			return super.execute();
		}
		if(directorid!=0&&!checkLevel(directorid)){
			setErrorCode(400,"参数directorid不能为0或者directorid不是高级管理员的userid");
			return super.execute();
		}
		
		Department department = departmentService.addDepartment(name,directorid);
		try {
			KvdbUtil.setDepartmentToKv(department);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (department == null) {
			setErrorCode(404);
			return super.execute();
		}
		response.setCode(200);
		response.setObject(department);
		return super.execute();
	}
	public boolean checkLevel(int directorid){
		User user=userService.queryUserById(directorid);
		return user.getLevel()==70?true:false;
	}

}
