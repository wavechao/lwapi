package com.wave.dao;

import com.wave.model.Title;
import com.wave.model.TitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TitleDao {
	public List<Title> getTitles();

	public Title query(int id);

	public Title add(Title title);

	public Title verify(int id, int pass);

	public List<Title> getMyTitle(int page, int count, int id);

	public List<Title> getTitleByState(int page, int count, int teacherid);
	
	public List<Title> getTitleByStateDept(int page, int count, int deptid);
	
	public Title plus(int id);
}