package com.wave.action.teachers;

import java.util.ArrayList;
import java.util.List;

import com.wave.action.BasicAciton;
import com.wave.model.User;
import com.wave.service.UserService;

public class LevelDownAction extends BasicAciton {
	private UserService userService;
	private String id;// 1,2,3

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute() {
		if (id == null || "".equals(id)) {
			setErrorCode(400,"老师id不能为空，准确的类型如2,3,4");
			return super.execute();
		}
		List<User>users=levelDown();
		response.setCode(200);
		response.setObject(users);
		return super.execute();
	}

	public List<User> levelDown() {
		List<User>users=new ArrayList<User>();
		String idStr[]=id.split(",");
		for(String str:idStr){
			int userid=Integer.parseInt(str);
			userService.leveldown(userid);
			User user=userService.queryTeacher(userid);
			if(user!=null){
				users.add(user);
			}
		}
		return users;
	}

}
