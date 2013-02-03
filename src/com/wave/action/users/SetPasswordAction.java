package com.wave.action.users;

import it.sauronsoftware.base64.Base64;

import com.wave.action.BasicAciton;
import com.wave.model.User;
import com.wave.service.UserService;
import com.wave.util.CodeUtil;
import com.wave.util.KvdbUtil;
import com.wave.util.Util;

public class SetPasswordAction extends BasicAciton {
	private String old_password;
	private String password;
	private UserService userService;

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() {
		if (Util.isNull(old_password) ) {
			setErrorCode(400,"参数old_password为空");
			return super.execute();
		}
		if (Util.isNull(password)) {
			setErrorCode(400,"参数password为空");
			return super.execute();
		}
		int user_id;
		try {
			user_id = getUserId();

			if (user_id == 0) {
				setErrorCode(404);
				return super.execute();
			}

			String subStr = password.substring(6);
			String endStr = Base64.decode(subStr, "UTF-8");
			String code[] = endStr.split(":");
			String password = CodeUtil.get256Encode(code[1]);

			User user = new User();
			user.setPassword(password);
			user.setUserid(user_id);
			user = userService.updateUserPassword(user);
			KvdbUtil.deleteUser(user.getUsername());
			response.setCode(200);
			response.setObject(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.execute();
	}

	public User getUser() throws Exception {
		String username = request.getAttribute("username").toString();
		return KvdbUtil.getUserFromKv(username);
	}

	private int getUserId() throws Exception {
		User user = getUser();
		// 解密
		old_password = Base64.decode(old_password, "UTF-8");
		System.out.println("old_password:"+old_password);
		// 加密
		old_password = CodeUtil.get256Encode(old_password);
		if (old_password.equals(user.getPassword())) {
			System.out.println("修改密码时密码验证成功");
			return user.getUserid();
		}
		System.out.println("old:"+old_password);
		System.out.println("password:"+user.getPassword());
		System.out.println("修改密码时密码验证失败");
		return 0;
	}

}
