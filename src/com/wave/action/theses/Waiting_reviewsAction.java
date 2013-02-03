package com.wave.action.theses;

import java.io.IOException;
import java.util.List;

import com.wave.action.BasicAciton;
import com.wave.model.Title;
import com.wave.model.User;
import com.wave.service.TitleService;
import com.wave.util.KvdbUtil;

public class Waiting_reviewsAction extends BasicAciton {
	private int page = 1;
	private int count = 20;
	private TitleService titleService;

	public void setPage(int page) {
		this.page = page;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setTitleService(TitleService titleService) {
		this.titleService = titleService;
	}

	public String execute() {
		try {
			User user = getUser();
			int level = user.getLevel();
			if (level == 40 || level == 30 || level == 70) {

				List<Title> titles = null;
				System.out.println("level:"+level+",userid:"+user.getUserid()+",deptid:"+user.getDepartment());
				if (level == 70) {
					titles = titleService.getTitleByStateDept(page, count, user.getDepartment_id());
				} else {
					titles = titleService.getTitleByState(page, count, user.getUserid());
				}
					response.setCode(200);
					response.setObject(titles);
			} else {
				setErrorCode(403);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return super.execute();
	}

	public User getUser() throws ClassNotFoundException, IOException {
		String username = (String) request.getAttribute("username");
		return KvdbUtil.getUserFromKv(username);
	}
}
