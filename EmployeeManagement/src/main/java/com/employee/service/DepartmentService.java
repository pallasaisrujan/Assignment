package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.repository.DepartmentRepository;
import com.employee.request.CreateDepartment;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department get_department(long id) {
		
		return departmentRepository.findById(id).get();
	}

	public Department add_department(CreateDepartment createDepartment) {
		
		Department department=new Department();
		department.setDepName(createDepartment.getDep_name());
		return departmentRepository.save(department);
	}

	public void delete_department(long id) {
		departmentRepository.deleteById(id);
		
	}



}
