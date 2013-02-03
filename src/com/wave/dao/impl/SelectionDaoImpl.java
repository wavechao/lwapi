package com.wave.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.wave.dao.SelectionDao;
import com.wave.model.Selection;

public class SelectionDaoImpl implements SelectionDao {

	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<Selection> getSelections() {
		
		return sqlSessionTemplate.selectList("testSelection");
	}

	public Selection query(int id) {
		
		Map map=new HashMap<String, Integer>();
		map.put("selectionid", id);
		return sqlSessionTemplate.selectOne("querySelection", map);
	}

	public Selection add(int studentid, int titleid) {
		Selection selection=new Selection();
		selection.setStudentid(studentid);
		selection.setTitleid(titleid);
		sqlSessionTemplate.insert("addSelection", selection);
		return query(selection.getSelectionid());
	}

	public Selection updateOralScore(int id, int score) {
		Selection selection=new Selection();
		selection.setSelectionid(id);
		selection.setOralScore((byte) score);
		sqlSessionTemplate.update("updateOralScore", selection);
		return query(id);
	}

	public Selection updateArticleScore(int id, int score) {
		Selection selection=new Selection();
		selection.setSelectionid(id);
		selection.setArticleScore((byte) score);
		sqlSessionTemplate.update("updateArticleScore", selection);
		return query(id);
	}

	public void delete(int id) {
		Map map=new HashMap<String, Integer>();
		map.put("id", id);
		sqlSessionTemplate.delete("deleteSelection",map);
	}

	public Selection queryBySid(int studentid) {
		Map map=new HashMap<String, Integer>();
		map.put("studentid", studentid);
		return sqlSessionTemplate.selectOne("querySelectionBySid", map);
	}

}
