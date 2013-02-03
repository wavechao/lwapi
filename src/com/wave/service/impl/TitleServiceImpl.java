package com.wave.service.impl;

import java.util.List;

import com.wave.dao.TitleDao;
import com.wave.model.Title;
import com.wave.service.TitleService;

public class TitleServiceImpl implements TitleService {
	private TitleDao titleDao;
	
	public TitleDao getTitleDao() {
		return titleDao;
	}

	public void setTitleDao(TitleDao titleDao) {
		this.titleDao = titleDao;
	}

	public List<Title> getTitles() {
		return titleDao.getTitles();
	}

	public Title query(int id) {
		return titleDao.query(id);
	}

	public Title add(Title title) {
		return titleDao.add(title);
	}

	public Title verify(int id, int pass) {
		// TODO Auto-generated method stub
		return titleDao.verify(id, pass);
	}
	
	public List<Title>getMyTitle(int page,int count ,int id){
		return titleDao.getMyTitle(page, count, id);
	}

	public List<Title> getTitleByState(int page, int count, int teacherid) {
		return titleDao.getTitleByState(page, count, teacherid);
	}

	public List<Title> getTitleByStateDept(int page, int count, int deptid) {
		// TODO Auto-generated method stub
		return titleDao.getTitleByStateDept(page, count, deptid);
	}

	public Title plus(int id) {
		// TODO Auto-generated method stub
		return titleDao.plus(id);
	}
}
