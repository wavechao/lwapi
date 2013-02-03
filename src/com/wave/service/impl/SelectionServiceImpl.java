package com.wave.service.impl;

import java.util.List;

import com.wave.dao.SelectionDao;
import com.wave.model.Selection;
import com.wave.service.SelectionService;

public class SelectionServiceImpl implements SelectionService {
	private SelectionDao selectionDao;
	
	public SelectionDao getSelectionDao() {
		return selectionDao;
	}

	public void setSelectionDao(SelectionDao selectionDao) {
		this.selectionDao = selectionDao;
	}

	public List<Selection> getSelections() {
		return selectionDao.getSelections();
	}

	public Selection query(int id) {
		
		return selectionDao.query(id);
	}

	public Selection add(int studentid, int titleid) {
		
		return selectionDao.add(studentid, titleid);
	}

	public Selection updateOralScore(int id, int score) {
		
		return selectionDao.updateOralScore(id, score);
	}

	public Selection updateArticleScore(int id, int score) {
		
		return selectionDao.updateArticleScore(id, score);
	}

	public void delete(int id) {
		
		selectionDao.delete(id);
	}

	public Selection queryBySid(int studentid) {
		return selectionDao.queryBySid(studentid);
	}
	
	

}
