package com.wave.action.teachers;

import java.util.List;

import com.wave.action.BasicAciton;
import com.wave.model.User;
import com.wave.service.UserService;

public class ShowAction extends BasicAciton{
	private int count = 20;
	private int page = 1;
	private int depart_id = 0;
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}
	@Override
	public String execute() {
		if(depart_id==0){
			setErrorCode(403,"depart_id´íÎó");
			return super.execute();
		}
		List<User>users=userService.getTeacher(depart_id, count, page);
		if(users==null||users.size()==0){
			setErrorCode(404);
			return super.execute();
		}
		
		response.setCode(200);
		response.setObject(users);
		return super.execute();
	}

}
