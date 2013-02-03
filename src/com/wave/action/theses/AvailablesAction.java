package com.wave.action.theses;

import java.io.IOException;
import java.util.List;

import com.wave.action.BasicAciton;
import com.wave.model.Title;
import com.wave.model.User;
import com.wave.service.TitleService;
import com.wave.util.KvdbUtil;

public class AvailablesAction extends BasicAciton {
	private int page=1;
	private int count=20;
	private TitleService titleService;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public TitleService getTitleService() {
		return titleService;
	}
	public void setTitleService(TitleService titleService) {
		this.titleService = titleService;
	}
	@Override
	public String execute() {
		try {
			User user=getUser();
			int id=user.getMajor_id();
			List<Title>titles=titleService.getMyTitle(page, count, id);
			if(titles==null&&titles.size()==0){
				setErrorCode(404);
				return super.execute();
			}
			response.setCode(200);
			response.setObject(titles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.execute();
	}
	public User getUser() throws ClassNotFoundException, IOException{
		String username=(String) request.getAttribute("username");
		return KvdbUtil.getUserFromKv(username);
	}

}
