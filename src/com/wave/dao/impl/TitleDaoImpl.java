package com.wave.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import com.wave.dao.TitleDao;
import com.wave.model.Title;

public class TitleDaoImpl implements TitleDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List<Title> getTitles() {
		return sqlSessionTemplate.selectList("testTitle");
	}

	public Title add(Title title) {
		sqlSessionTemplate.insert("addTitle", title);
		return query(title.getTitleid());
	}

	public Title query(int id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		return sqlSessionTemplate.selectOne("getTitle", map);
	}

	public Title verify(int id, int pass) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		map.put("pass", pass);
		sqlSessionTemplate.update("pass", map);
		return query(id);
	}

	public List<Title> getMyTitle(int page, int count, int id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "%" + id + "%");
		RowBounds rw = new RowBounds((page - 1) * count, count);
		return sqlSessionTemplate.selectList("getMyTitle", map, rw);
	}

	public List<Title> getTitleByState(int page, int count, int teacherid) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("teacherid", teacherid);
		RowBounds rw = new RowBounds((page - 1) * count, count);
		return sqlSessionTemplate.selectList("getTitleByState", map, rw);
	}
	public List<Title> getTitleByStateDept(int page, int count, int deptid) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("deptid", deptid);
		RowBounds rw = new RowBounds((page - 1) * count, count);
		return sqlSessionTemplate.selectList("getTitleByStateDept", map, rw);
	}

	public Title plus(int id) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		sqlSessionTemplate.update("plus", map);
		return query(id);
	}
}
