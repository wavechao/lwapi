package com.wave.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.wave.dao.MajorDao;
import com.wave.model.Major;

public class MajorDaoImpl implements MajorDao {
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List<Major> queryAllMajor() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("queryAllMajor");
	}

	public List<Major> queryMajorByDeptId(long deptid) {
		// TODO Auto-generated method stub
		Map<String ,String> map=new HashMap<String, String>();
		map.put("deptid",deptid+"");
		return sqlSessionTemplate.selectList("queryMajorByDeptId", map);
	}

	public Major queryMajorById(long id) {
		// TODO Auto-generated method stub
		Map<String ,String> map=new HashMap<String, String>();
		map.put("majorid",id+"");
		return sqlSessionTemplate.selectOne("queryMajorById", map);
	}

	public Major addMajor(Major major) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("addMajor", major);
		int majorid=major.getMajorid();
		return queryMajorById(majorid);
	}

	public void update(Major major) {
		// TODO Auto-generated method stub
		Map<String ,String> map=new HashMap<String, String>();
		map.put("deptid",major.getDeptid()+"");
		map.put("name", major.getName());
		map.put("id", major.getMajorid()+"");
		int result=sqlSessionTemplate.insert("updateMajor", map);
		
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		Map<String ,String> map=new HashMap<String, String>();
		map.put("id",id+"");
		int result=sqlSessionTemplate.delete("deleteMajorById", map);
	}
}
