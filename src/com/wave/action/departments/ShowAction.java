package com.wave.action.departments;

import java.util.List;

import com.wave.action.BasicAciton;
import com.wave.model.Department;
import com.wave.service.DepartmentsService;
import com.wave.util.KvdbUtil;

public class ShowAction extends BasicAciton {
	private DepartmentsService departmentService;


	public DepartmentsService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentsService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public String execute() {
		List<Department> departments = null;
		try {
			departments = KvdbUtil.getAllDepartment();
			if(departments!=null&&departments.size()>0){
				response.setCode(200);
				response.setObject(departments);
				return super.execute();
			}
			
			
			departments = departmentService.queryAllDepartments();
			if (departments == null || departments.size() == 0) {
				setErrorCode(404);
			} else {
				KvdbUtil.setAllDepartmentToKv(departments);
				response.setCode(200);
				response.setObject(departments);
			}
			
		} catch (Exception e) {
			setErrorCode(404);
			e.printStackTrace();
		}
		return super.execute();
	}
}
