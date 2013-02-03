package com.wave.action.theses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wave.action.BasicAciton;
import com.wave.model.Title;
import com.wave.model.User;
import com.wave.service.MajorService;
import com.wave.service.TitleService;
import com.wave.util.KvdbUtil;
import com.wave.util.Util;

public class CreateTitleAction extends BasicAciton {
	private TitleService titleService;
	private MajorService majorService;
	private String title;
	private int student_num;
	private String available_majors;// 逗号分隔id
	private String description;
	private String require_info;

	public TitleService getTitleService() {
		return titleService;
	}

	public void setTitleService(TitleService titleService) {
		this.titleService = titleService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStudent_num() {
		return student_num;
	}

	public void setStudent_num(int student_num) {
		this.student_num = student_num;
	}

	public String getAvailable_majors() {
		return available_majors;
	}

	public void setAvailable_majors(String available_majors) {
		this.available_majors = available_majors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequire_info() {
		return require_info;
	}

	public void setRequire_info(String require_info) {
		this.require_info = require_info;
	}

	@Override
	public String execute() {
		if (Util.isNull(available_majors) ) {
			setErrorCode(400,"参数available_majors错误");
			return super.execute();
		}
		
		if(Util.isNull(description)){
			setErrorCode(400, "参数description错误");
			return super.execute();
		}
		
		
		// 判断权限
		User user = getUser();
		if (user.getLevel() != 40) {
			setErrorCode(403);
			return super.execute();
		}
		Title myTitle = get(user.getDepartment_id(), user.getUserid());
		Title titleFromDb = titleService.add(myTitle);
		if(titleFromDb==null){
			setErrorCode(404);
			return super.execute();
		}
		response.setCode(200);
		response.setObject(titleFromDb);
		return super.execute();
	}

	public Title get(int deptid, int teacherid) {
		Title myTitle = new Title();
		myTitle.setAvailableMajors(available_majors);
		myTitle.setDeptid(deptid);
		myTitle.setDescription(description);
		myTitle.setRequireInfo(require_info);
		myTitle.setStudentNum((byte) student_num);
		myTitle.setTitle(title);
		myTitle.setTeacherid(teacherid);
		return myTitle;
	}

	// 获取用户
	public User getUser() {
		String username = (String) request.getAttribute("username");
		try {
			User user = KvdbUtil.getUserFromKv(username);
			return user;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Integer> getList() {
		String[] strs = available_majors.split(",");
		List<Integer> lists = new ArrayList<Integer>();
		for (String str : strs) {
			lists.add(Integer.parseInt(str));
		}
		return lists;
	}
}
