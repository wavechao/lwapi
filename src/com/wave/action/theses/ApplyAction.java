package com.wave.action.theses;

import com.wave.action.BasicAciton;
import com.wave.model.Title;
import com.wave.model.User;
import com.wave.service.TitleService;
import com.wave.service.UserService;
import com.wave.util.KvdbUtil;
import com.wave.util.Util;

public class ApplyAction extends BasicAciton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private int student_num;
	private int teacherid;// 只能是相同系的出题教师
	private String description;// 其他的deptid用学生的、可选专业只能学生相同专业
	private UserService userService;
	private TitleService titleService;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStudent_num(int student_num) {
		this.student_num = student_num;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setTitleService(TitleService titleService) {
		this.titleService = titleService;
	}

	@Override
	public String execute() {
		if (Util.isNull(description) ) {
			setErrorCode(400,"description不为空");
			return super.execute();
		}
		if(Util.isNull(title)){
			setErrorCode(400,"title不能为空");
			return super.execute();
		}
		if(teacherid == 0){
			setErrorCode(400,"teacherid错误");
			return super.execute();
		}
		User user = getUser();
		int deptid = user.getDepartment_id();

		if (getDeptid() != deptid) {
			setErrorCode(400,"deptid不是所操作系别的id");
			
			return super.execute();
		}
		int majorid = user.getMajor_id();

		Title mytitle = new Title();
		mytitle.setDeptid(deptid);
		mytitle.setAvailableMajors(majorid + "");
		mytitle.setTeacherid(teacherid);
		mytitle.setTitle(title);
		mytitle.setDescription(description);
		mytitle.setRequireInfo("");
		mytitle.setState((byte) 2);
		mytitle.setStudentNum((byte) student_num);
		Title titleFromDbTitle = titleService.add(mytitle);
		if (titleFromDbTitle == null) {
			setErrorCode(403);
			return super.execute();
		}

		response.setCode(200);
		response.setObject(titleFromDbTitle);
		return super.execute();
	}

	public User getUser() {
		String username = (String) request.getAttribute("username");
		try {
			return KvdbUtil.getUserFromKv(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getDeptid() {
		User user = userService.queryTeacher(teacherid);
		if (user == null) {
			return 0;
		}
		return user.getDepartment_id();
	}

}
