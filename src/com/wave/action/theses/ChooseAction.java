package com.wave.action.theses;

import com.wave.action.BasicAciton;
import com.wave.model.Selection;
import com.wave.model.Title;
import com.wave.model.User;
import com.wave.service.SelectionService;
import com.wave.service.TitleService;
import com.wave.util.KvdbUtil;

public class ChooseAction extends BasicAciton {
	private int titleid;
	private SelectionService selectionService;
	private TitleService titleService;
	
	public void setTitleService(TitleService titleService) {
		this.titleService = titleService;
	}
	public void setTitleid(int titleid) {
		this.titleid = titleid;
	}
	public void setSelectionService(SelectionService selectionService) {
		this.selectionService = selectionService;
	}
	public String execute() {
		if(titleid==0){
			setErrorCode(400,"titlid错误");
			return super.execute();
		}
		User user=getUser();
		if(user.getLevel()!=10){
			setErrorCode(403);
			response.setMessage("只有学生才能选课");
			return super.execute();
		}
		int id=user.getUserid();
		Selection selection=selectionService.queryBySid(id);
		if(selection!=null){
			setErrorCode(403);
			response.setMessage("你已经选好课了");
			return super.execute();
		}
		Title title=titleService.query(titleid);
		
		if(title.getDeptid()!=user.getDepartment_id()){
			setErrorCode(403);
			response.setMessage("只能选本系的题目");
			return super.execute();
		}
		
		if(title.getStudentNum()<1){
			setErrorCode(403);
			response.setMessage("该论题可选人数已完");
			return super.execute();
		}
		
	    selection=selectionService.add(id, titleid);
		titleService.plus(titleid);
		response.setCode(200);
		response.setObject(selection);
		return super.execute();
	}
	public User getUser(){
		String username=(String) request.getAttribute("username");
		try {
			return KvdbUtil.getUserFromKv(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
