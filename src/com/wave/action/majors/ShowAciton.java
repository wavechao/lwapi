package com.wave.action.majors;

import com.wave.action.BasicAciton;
import com.wave.model.Department;
import com.wave.service.DepartmentsService;
import com.wave.util.KvdbUtil;

public class ShowAciton extends BasicAciton {
	private DepartmentsService departmentService;
	
	private long department_id = 0;
	
	public DepartmentsService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentsService departmentService) {
		this.departmentService = departmentService;
	}


	public long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(long department_id) {
		this.department_id = department_id;
	}

	@Override
	public String execute() {
		if (department_id == 0) {
			setErrorCode(400,"Ïµ±ðid´íÎó");
			return super.execute();
		}

		Department department;
		try {
			department = KvdbUtil.getDepartmentFromKv(department_id + "");
			if (department == null) {
				department = departmentService.queryDepartmentsById(department_id);
			}


			if (department != null) {
				KvdbUtil.setDepartmentToKv(department);
				response.setCode(200);
				response.setObject(department.getMajors());
			} else {
				setErrorCode(404);
			}
		} catch (Exception e) {
			setErrorCode(404,e.getMessage());
		}

		return super.execute();
	}

}
