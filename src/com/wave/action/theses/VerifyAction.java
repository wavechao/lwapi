package com.wave.action.theses;

import com.wave.action.BasicAciton;
import com.wave.model.Title;
import com.wave.model.User;
import com.wave.service.TitleService;
import com.wave.util.KvdbUtil;

public class VerifyAction extends BasicAciton {
	private int title_id;
	private int pass;//0审核通过但是高级管理员不通过，1高级管理员审核通过，2学生申请的论题
	private TitleService titleService;
	public int getTitle_id() {
		return title_id;
	}
	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public TitleService getTitleService() {
		return titleService;
	}
	public void setTitleService(TitleService titleService) {
		this.titleService = titleService;
	}
	@Override
	public String execute() {
		if(title_id==0){
			setErrorCode(400,"title_id错误");
			return super.execute();
		}
		if(pass<0||pass>2){
			setErrorCode(400,"pass错误");
			return super.execute();
		}
		
		
		
		Title mytitle=titleService.query(title_id);
		User user=getUser();
		int state=mytitle.getState();
		int level=user.getLevel();
		Title title=null;
		System.out.println("state:"+state+",pass:"+pass+",level:"+level);
		//判断是老师还是高级管理员和它所能设置的值
		if(state==0&&level==70||(pass==0||pass==1)){
			 title=titleService.verify(title_id, pass);
		}else if(state==2&&(level==30||level==40)&&(pass==0||pass==2)){
			 title=titleService.verify(title_id, state);
		}else {
			setErrorCode(403);
			return super.execute();
		}
		
		if(title==null){
			setErrorCode(404);
			return super.execute();
		}
		response.setCode(200);
		response.setObject(title);
		return super.execute();
	}
	public User getUser(){
		String username=(String) request.getAttribute("username");
		try {
			return KvdbUtil.getUserFromKv(username);
		}catch (Exception e) {
			System.out.println("exception---->"+e.getMessage());
			return null;
		}
		
	}
	 
}
