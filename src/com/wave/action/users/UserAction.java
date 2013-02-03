package com.wave.action.users;

import com.wave.action.BasicAciton;
import com.wave.model.User;
import com.wave.service.UserService;

/**
 * 类说明：用户Action
 * 
 * @author 作者: LiuJunGuang
 * @version 创建时间：2012-3-25 下午03:29:52
 */
public class UserAction extends BasicAciton {
	private UserService userService;
	private long user_id = 0;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {
		return null;
	}

	public String delete() {
		if (user_id != 0) {
			userService.deleteUser(user_id);
			response.setCode(200);
		} else {
			setErrorCode(400,"参数user_id错误");
		}

		return super.execute();
	}

	public String show() {
		if (user_id == 0) {
			setErrorCode(400);
			return super.execute();
		}
		User user = userService.queryUserById(user_id);
		if (user != null) {
			response.setCode(200);
			response.setObject(user);
		} else {
			setErrorCode(404);
		}

		return super.execute();
	}

	public String login() {
		User user = userService.login(username, password);
		if (user != null) {
			response.setCode(200);
			response.setObject(user);
		} else {
			setErrorCode(401);
		}
		return super.execute();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


}
