package com.wave.action.user;

import java.io.IOException;
import com.wave.action.BasicAciton;
import com.wave.model.Major;
import com.wave.model.User;
import com.wave.service.MajorService;
import com.wave.service.UserService;
import com.wave.util.KvdbUtil;
import com.wave.util.Util;

public class UpdateAction extends BasicAciton {
	private int userid;
	private int deptid;// 若传majorid 可不传
	private int majorid;// 高级管理员、管理员、教师可选，学生必选
	private int level;// 必选，只能创建比当前账户低的类型，注意类型有限制，只能传现在定好的那几个

	private int gender;// 可选
	private String email;// 可选
	private String screenname;// 可选

	private UserService userService;
	private MajorService majorService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public int getMajorid() {
		return majorid;
	}

	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	@Override
	public String execute() {
		if(userid==0){//没传userid，显示400错误
			setErrorCode(400,"参数userid错误");
			return super.execute();
		}
		//判断有没有权限
		if(!checkLevel()){
			setErrorCode(403);
			return super.execute();
		}
		
		//判断
		User user=getUser();
		
		User userFromDb=userService.updateUser(user);
		if(userFromDb==null){
			setErrorCode(502);
			return super.execute();
		}
		//
		KvdbUtil.deleteUser(userFromDb.getUsername());
		response.setCode(200);
		response.setObject(userFromDb);
		return super.execute();
	}

	public User getUser() {
		User user = new User();
		user.setUserid(userid);
		user.setLevel((byte) level);//设置权限
		if (!Util.isNull(email))
			user.setEmail(email);//设置邮箱
		if (!Util.isNull(screenname))
			user.setScreenname(screenname);//设置昵称
		user.setGender((byte) gender);//设置性别
		if (majorid != 0){
			user.setMajor_id(majorid);//设置专业
			deptid=getDepartmentid();
		}
		user.setDepartment_id(deptid);//设置系别
		return user;
	}
	public int getDepartmentid(){
		Major major=majorService.queryMajorById(majorid);
		if(major!=null){
			return major.getDeptid();
		}
		return 0;
	}

	// 建议权限
	public boolean checkLevel() {
		String name = (String) request.getAttribute("username");
		User user = null;
		try {
			user = KvdbUtil.getUserFromKv(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("userlevel:"+user.getLevel()+",level:"+level);
		return user.getLevel() > level ? true : false;
	}
}
