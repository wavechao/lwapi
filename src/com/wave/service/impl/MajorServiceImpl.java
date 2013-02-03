package com.wave.service.impl;

import java.io.IOException;
import java.util.List;

import com.wave.dao.DepartmentDao;
import com.wave.dao.MajorDao;
import com.wave.model.Department;
import com.wave.model.Major;
import com.wave.service.MajorService;
import com.wave.util.KvdbUtil;

public class MajorServiceImpl implements MajorService {
	private MajorDao majorDao;
	private DepartmentDao departmentDao;

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public MajorDao getMajorDao() {
		return majorDao;
	}

	public void setMajorDao(MajorDao majorDao) {
		this.majorDao = majorDao;
	}

	public List<Major> queryAllMajor() {
		// TODO Auto-generated method stub
		return majorDao.queryAllMajor();
	}

	public List<Major> queryMajorByDeptId(long deptid) {
		// TODO Auto-generated method stub
		return majorDao.queryMajorByDeptId(deptid);
	}

	public Major queryMajorById(long id) {
		// TODO Auto-generated method stub
		Major major = majorDao.queryMajorById(id);
		major.setDepartment(departmentDao.queryDepartmentsById(major
				.getDeptid()));
		return major;
	}

	public Major addMajor(Major major) {
		// TODO Auto-generated method stub
		Major m=majorDao.addMajor(major);
		m=setDepartment(m);
		return m;
	}
	public Major setDepartment(Major major){
		//去kvdb数据库去
		int id=major.getDeptid();
		Department department=departmentDao.queryDepartmentsById(id);
		List<Major>majors=majorDao.queryMajorByDeptId(id);
		department.setMajors(majors);
		major.setDepartment(department);
//		try {
//			department = KvdbUtil.getDepartmentFromKv(major
//					.getDeptid()+"");
//			m.setDepartment(department);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
		
		return major;
	}

	public void update(Major major) {
		majorDao.update(major);
	}

	public void delete(long id) {
		majorDao.delete(id);
	}

}
