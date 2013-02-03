package com.wave.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wave.model.Department;

public interface DepartmentsService {
	public Department addDepartment(String departmentsname,int directorid);
	public void deleteDepartments(long depteid );
	public void updateDepartments(Department departments);
	public List<Department> queryAllDepartments();
	public Department queryDepartmentsById(long id);
}
