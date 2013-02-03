package com.wave.service;

import java.util.List;

import com.wave.model.Selection;

public interface SelectionService {
	public List<Selection>getSelections();
	public Selection query(int id);
	public Selection queryBySid(int studentid);
	public Selection add(int studentid,int titleid);
	public Selection updateOralScore(int id,int score);
	public Selection updateArticleScore(int id,int score);
	public void delete(int  id);
}
