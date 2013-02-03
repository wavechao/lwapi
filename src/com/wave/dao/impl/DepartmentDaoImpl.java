package com.wave.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.wave.dao.DepartmentDao;
import com.wave.model.Department;
import com.wave.service.DepartmentsService;

public class DepartmentDaoImpl implements DepartmentDao{
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	

	public void updateDepartments(Department departments) {
		
		Map< String,String>map=new HashMap<String, String>();
		map.put("name",departments.getName());
		map.put("schoolname", departments.getSchoolname());
		map.put("deptid", departments.getDeptid()+"");
		map.put("directorid", departments.getDirectorid()+"");
		int result=sqlSessionTemplate.update("updateDepartment", map);
		System.out.println("更新部门"+departments.getDeptid()+"成功？"+(result>0));
	}

	public List<Department> queryAllDepartments() {
		
		return sqlSessionTemplate.selectList("queryAllDepartment");
	}

	public Department queryDepartmentsById(long id) {
		
		Map map=new HashMap<String,Integer>();
		map.put("deptid",id);
		Department department= sqlSessionTemplate.selectOne("queryDepartmentById", map);
		return  department;
	}


	public void deleteDepartments(long depteid) {
		
		Map map=new HashMap<String,String>();
		map.put("depteid",depteid+"");
		int result=sqlSessionTemplate.delete("deleteDepartment", map);
		System.out.println("更新部门"+depteid+"成功？"+(result>0));
	}

	public Department addDepartment(String departmentsname, int directorid) {
		Department department=new Department();
		department.setName(departmentsname);
		department.setDirectorid(directorid);
		department.setSchoolname("中山大学南方学院");
		sqlSessionTemplate.insert("addDepartment", department);
		return queryDepartmentsById(department.getDeptid());
	}


}
