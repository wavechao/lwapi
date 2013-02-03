package com.wave.model;

import java.io.Serializable;

import org.apache.struts2.json.annotations.JSON;

public class User implements Serializable {
	private static final long serialVersionUID =-4872631895491761787l;
	private Integer userid;

	private String username;

	private String password;

	private String screenname;

	private Byte gender;

	private Byte level;

	private String email;

	private String avatar;

	private String avatar_thumb;

	private int department_id;

	private Department department;

	private int major_id;
	
	

	public int getMajor_id() {
		return major_id;
	}

	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}

	@JSON(serialize = false)
	public String getPassword() {
		return password;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatar_thumb() {
		return avatar_thumb;
	}

	public void setAvatar_thumb(String avatar_thumb) {
		this.avatar_thumb = avatar_thumb;
	}
	@JSON(serialize = false)
	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	public void setPassword(String password) {
		this.password = password;
	}
}