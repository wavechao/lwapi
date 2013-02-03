package com.wave.filter;

import it.sauronsoftware.base64.Base64;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.wave.model.User;
import com.wave.service.UserService;
import com.wave.util.CodeUtil;
import com.wave.util.KvdbUtil;
import com.wave.util.Response;

public class LoginFilter implements Filter {
	@Autowired
	private static UserService userService;
	private com.wave.util.Response resultResponse = new Response();
	// 普通用户 可以访问的url
	private final static String studentUrl = "/account/update_profile.json"+","+"/account/update_avatar.json"+","+"/departments/show.json"+","+"/majors/show.json"+"/theses/apply.json" ;
	// 管理员 可以访问的url
	private final static String  adminUrl = "/users/create.json"+","+"/departments/show.json"+","+"/teachers/leveldown.json"+","+"/teachers/levelup.json";
	// 高级管理员
	private final static String  advAdminUrl = "" ;
	// 超级管理员用户 可以访问的url
	private final static String  superAdminUrl =  "/department/create.json";
	// 超级管理员用户 可以访问的url
	private final static String  teacherUrl = "/theses/create_title.json"+","+ "/theses/verify.json"+","+"/theses/";


	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
//		System.out.println("--------filter---------");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		req.setCharacterEncoding("utf-8");
		setHttp(request, response);
	
		
		String questStr=request.getMethod();
//		System.out.println("methods:"+questStr);
		if(!questStr.equals("GET")&&!questStr.equals("POST"))
		return ;
		
		String url = request.getServletPath();
//		System.out.println("url:"+url);
		//登陆接口无需验证，跳向登陆接口
		if (url.equals("/account/verify_credentials.json")) {
			chain.doFilter(request, response);
			return;
		}
		
		
		//获取不到值输出401，需要验证消息
		String authStr = request.getHeader("Auth");
//		System.out.println("authStr:"+authStr);
		if (authStr == null || "".equals(authStr)) {
			print(response, 502);
			return;
		}

		//从kvdb中获取数据或者从数据库获取用户，抛出异常则证明参数错误
		User user = null;
			try {
				user = getUser(authStr);
			} catch (Exception e) {
				
				System.out.println("登陆异常："+e.getMessage());
				print(response, 502);
				return ;
			}
			System.out.println("user==null?"+(user==null)+",quanxuan:"+check(url, user));
		//判断用户是否有权限访问数据
		if (user != null && check(url, user)) {
			request.setAttribute("username", user.getUsername());
			chain.doFilter(request, response);
		} else {
			System.out.println("error:403 user==null");
			print(response, 403);
		}

	}

	//设置http的信息
	private void setHttp(HttpServletRequest request,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Auth,X-File-Size,X-File-Name");
		response.setHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS");
	}

	private void print(HttpServletResponse response, int code) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			resultResponse.setCode(code);
			String resultStr = new Gson().toJson(resultResponse);
			out.print(resultStr);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		userService = (UserService) ac.getBean("userService");
	}

	public User getUser(String headerStr) throws ClassNotFoundException, IOException  {
		String subStr = headerStr.substring(6);
		String endStr = Base64.decode(subStr, "UTF-8");
		String code[] = endStr.split(":");
		String username = code[0];
		String password = CodeUtil.get256Encode(code[1]);
		User user = KvdbUtil.getUserFromKv(username);
		 	
		 if (user != null&&user.getUsername().equals(password)) {
			 System.out.println("从kvdb中获取user不为空");
			 return user;
		 } else {
			 System.out.println("kvdb中没有该用户-->login");
			 User u= userService.login(username, password);
			 KvdbUtil.setUserToKv(u);
			 return u;
		 }
	}


	private boolean check(String uri, User user) {
		System.out.println("uri---->"+uri+",spuerAdminUrl:"+superAdminUrl.toString());
		int count = 0;
		if (superAdminUrl.toString().indexOf(uri) > -1) {
			count = 80;
		} else if (advAdminUrl.toString().indexOf(uri) > -1) {
			count = 70;
		} else if (adminUrl.toString().indexOf(uri) > -1) {
			count = 60;
		} else if (teacherUrl.toString().indexOf(uri) > -1) {
			count = 30;
		} else if (studentUrl.toString().indexOf(uri) > -1)
			count = 10;
		System.out.println("用户的权限值为：" + user.getLevel() + ", uri：" + uri
				+ ",需要的权限值为：" + count);
		return user.getLevel() >= count;
	}

}
