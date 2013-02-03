package com.wave.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wave.model.Department;

public interface DepartmentDao {
	public Department addDepartment(@Param("departmentsname") String departmentsname,@Param("id")int directorid );
	public void deleteDepartments(@Param("id")long depteid );
	public void updateDepartments(Department departments);
	public List<Department> queryAllDepartments();
	public Department queryDepartmentsById(long id);
}