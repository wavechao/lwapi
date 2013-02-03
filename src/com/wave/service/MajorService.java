package com.wave.service;

import java.util.List;

import com.wave.model.Major;

public interface MajorService {
	List<Major> queryAllMajor();

	List<Major> queryMajorByDeptId(long deptid);

	Major queryMajorById(long id);

	Major addMajor(Major major);

	void update(Major major);

	void delete(long id);

}
