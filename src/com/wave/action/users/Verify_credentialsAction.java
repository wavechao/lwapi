package com.wave.action.users;

import it.sauronsoftware.base64.Base64;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.wave.action.BasicAciton;
import com.wave.model.Department;
import com.wave.model.User;
import com.wave.service.DepartmentsService;
import com.wave.service.UserService;
import com.wave.util.CodeUtil;
import com.wave.util.KvdbUtil;

public class Verify_credentialsAction extends BasicAciton {
	private UserService userService;

	private DepartmentsService departmentService;

	public UserService getUserService() {
		return userService;
	}

	public DepartmentsService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentsService departmentService) {
		this.departmentService = departmentService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() {
		HttpServletRequest req = (HttpServletRequest) request;
		String authStr = request.getHeader("Auth");
		if (authStr == null || "".equals(authStr)) {
			setErrorCode(400,"²ÎÊýauthStr´íÎó");
			return super.execute();
		}

		User user = null;
		try {
			user = getUser(authStr);

			if (user != null) {
				int deptid=user.getDepartment_id();
				Department department = departmentService.queryDepartmentsById(deptid);
				user.setDepartment(department);
				response.setCode(200);
				response.setObject(user);
				KvdbUtil.setUserToKv(user);
			} else {
				System.out.println("sql query fail");
				setErrorCode(403);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.execute();
	}

	public User getUser(String authStr) throws ClassNotFoundException,
			IOException {
		String subStr = authStr.substring(6);
		String endStr = Base64.decode(subStr, "UTF-8");
		String code[] = endStr.split(":");
		String username = code[0];
		String password = CodeUtil.get256Encode(code[1]);
		User user = KvdbUtil.getUserFromKv(username);
		if (user != null && user.getPassword().equals(password)) {
			System.out.println("kvdb check pass");
		} else {
			user = userService.login(username, password);
			System.out.println("username:" + user.getUsername());
		}

		return user;
	}

}
