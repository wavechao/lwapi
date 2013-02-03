package com.wave.service.impl;

import java.util.List;

import sun.java2d.d3d.D3DGraphicsDevice;

import com.wave.dao.DepartmentDao;
import com.wave.dao.MajorDao;
import com.wave.model.Department;
import com.wave.model.Major;
import com.wave.service.DepartmentsService;

public class DepartmentServiceImpl implements DepartmentsService {
	private DepartmentDao departmentDao;
	private MajorDao majorDao;

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public MajorDao getMajorDao() {
		return majorDao;
	}

	public void setMajorDao(MajorDao majorDao) {
		this.majorDao = majorDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}


	public void deleteDepartments(long depteid) {

		departmentDao.deleteDepartments(depteid);
	}

	public void updateDepartments(Department departments) {

		departmentDao.updateDepartments(departments);
	}

	public List<Department> queryAllDepartments() {
		List<Department> departments = departmentDao.queryAllDepartments();
		for (int i = 0; departments != null && i < departments.size(); i++) {
			Department department = departments.get(i);
			department.setMajors(majorDao.queryMajorByDeptId(department
					.getDeptid()));
			departments.set(i, department);
		}
		return departments;
	}

	public Department queryDepartmentsById(long id) {

		Department department = departmentDao.queryDepartmentsById(id);
		List<Major> majors = majorDao
				.queryMajorByDeptId(department.getDeptid());
		department.setMajors(majors);
		return department;
	}

	public Department addDepartment(String departmentsname, int directorid) {
		System.out.println("name--->"+departmentsname+",id:"+directorid);
		Department department=departmentDao.addDepartment(departmentsname, directorid);
		department.setMajors(majorDao.queryMajorByDeptId(department.getDeptid()));
		return department;
	}

}
