package com.wave.action.users;

import java.io.IOException;

import it.sauronsoftware.base64.Base64;

import javax.servlet.http.HttpServletRequest;

import com.wave.action.BasicAciton;
import com.wave.model.User;
import com.wave.service.UserService;
import com.wave.util.CodeUtil;
import com.wave.util.KvdbUtil;
import com.wave.util.Util;

public class CreateAction extends BasicAciton {
	private UserService userService;
	private String auth_info;
	private String screenname;

	private int gender = 0;

	private int level = 0;

	private int department = 0;

	private int major = 0;

	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getAuth_info() {
		return auth_info;
	}

	public void setAuth_info(String auth_info) {
		this.auth_info = auth_info;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	@Override
	public String execute() {
	
		
		// 获取字段,判断是否为空
		HttpServletRequest req = (HttpServletRequest) request;
		String authStr = request.getHeader("auth_info");
		if (Util.isNull(auth_info) ) {
			setErrorCode(400,"参数auth_info为空");
			return super.execute();
		}
		
		if (Util.isNull(screenname)) {
			setErrorCode(400,"参数screenname为空");
			return super.execute();
		}
		
		
		if ( gender == 0) {
			setErrorCode(400,"参数gender错误");
			return super.execute();
		}
		
		if ( level == 0 ) {
			setErrorCode(400,"参数level错误");
			return super.execute();
		}
		
		if ( department == 0 ) {
			setErrorCode(400,"参数department错误");
			return super.execute();
		}
		
		if ( major == 0 ) {
			setErrorCode(400,"参数major错误");
			return super.execute();
		}
		
		
		
		User loginUser = getLoginUser();
		System.out.println("user==null--->"+(loginUser==null));
		if(level>loginUser.getLevel()){
			setErrorCode(403);
			return super.execute();
		}

		// 解析字段
		User user=getUser(auth_info);
		user.setScreenname(screenname);
		user.setGender((byte) gender);
		user.setLevel((byte) level);
		user.setDepartment_id(department);
		user.setMajor_id(major);
		
		User userFromDb=userService.addUser(user);
		if(userFromDb!=null){
			response.setCode(200);
			response.setObject(userFromDb);
		}else{
			setErrorCode(404);
		}
		return super.execute();
	}

	// 获取当前登录用户
	private User getLoginUser() {
		String str = request.getHeader("Auth");
		String subStr = str.substring(6);
		String endStr = Base64.decode(subStr, "UTF-8");
		String code[] = endStr.split(":");
		String username = code[0];
		User user=null;
		try {
			user=KvdbUtil.getUserFromKv(username);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User getUser(String authStr) {
		String subStr = authStr.substring(6);
		String endStr = Base64.decode(subStr, "UTF-8");
		String code[] = endStr.split(":");
		String username = code[0];
		String password = CodeUtil.get256Encode(code[1]);
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}

}
