package com.wave.action.theses;

import com.wave.action.BasicAciton;
import com.wave.model.Selection;
import com.wave.model.User;
import com.wave.service.SelectionService;
import com.wave.util.KvdbUtil;

public class CurrentShowAction extends BasicAciton {
	private SelectionService selectionService;
	
	public void setSelectionService(SelectionService selectionService) {
		this.selectionService = selectionService;
	}
	
	public String execute() {
		User user =getUser();
		if(user.getLevel()!=10){
			setErrorCode(403,"只有学生才有权限访问");
			return super.execute();
		}
		Selection selection=selectionService.queryBySid(user.getUserid());
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
