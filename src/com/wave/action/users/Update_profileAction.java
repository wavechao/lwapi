package com.wave.action.users;

import java.io.IOException;

import it.sauronsoftware.base64.Base64;

import com.wave.action.BasicAciton;
import com.wave.model.User;
import com.wave.service.UserService;
import com.wave.util.CodeUtil;
import com.wave.util.KvdbUtil;
import com.wave.util.Util;

public class Update_profileAction extends BasicAciton {

	private UserService userService;
	private String email = "";
	private int gender = 0;
	private String screenname = "";

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	@Override
	public String execute() {

		try {
		
		User user = getUser();

		User userFromDb = userService.updateUser(user);
		if (userFromDb == null) {
			setErrorCode(404);
		} else {
			KvdbUtil.delete(userFromDb.getUsername());
			response.setCode(200);
			response.setObject(userFromDb);
		}
		}catch (Exception e) {
			System.out.println("e:"+e.getMessage());
			setErrorCode(500);
		}
		return super.execute();
	}

	private User getUser() throws ClassNotFoundException, IOException {
		User user = new User();
		String username=(String) request.getAttribute("username");
		user =KvdbUtil.getUserFromKv(username);
		user.setEmail(email);
		user.setScreenname(screenname);
		user.setGender((byte) gender);
		System.out.println("¸üÐÂÍ·Ïñ£ºemail:" + user.getEmail() + ",screenname:"
				+ user.getScreenname());
		return user;
	}

}
