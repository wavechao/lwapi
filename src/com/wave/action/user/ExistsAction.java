package com.wave.action.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.wave.action.BasicAciton;
import com.wave.model.User;
import com.wave.service.UserService;
import com.wave.util.KvdbUtil;

public class ExistsAction extends BasicAciton {
	private String username;
	
	private UserService userService;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() {
		if(username==null||username.equals("")){
			setErrorCode(400,"参数username不为空");
			return super.execute();
		}
		try {
			User user=getUser();
			Map map=new HashMap<String, Integer>();
			
			if(user==null){
				map.put("result", 0);
			}else{
				map.put("result", 1);
			}
			response.setCode(200);
			response.setObject(map);
		} catch (Exception e) {
			setErrorCode(502);
			return super.execute();
		}
		return super.execute();
	}
	
	public User getUser() throws ClassNotFoundException, IOException{
		User user=KvdbUtil.getUserFromKv(username);
		if(user==null){
			user=userService.findUser(username);
			if(user!=null){
				KvdbUtil.setUserToKv(user);
			}
		}
		return user;
	}

}
