package com.wave.dao;

import java.util.List;

import com.wave.model.Major;

public interface MajorDao {
	List<Major> queryAllMajor();

	List<Major> queryMajorByDeptId(long deptid);

	Major queryMajorById(long id);

	Major addMajor(Major major);

	void update(Major major);

	void delete(long id);
}