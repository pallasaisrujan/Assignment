package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Department;

import com.employee.request.CreateDepartment;

import com.employee.service.DepartmentService;

@RestController
@RequestMapping("api/department/")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("getdepartment/{department_id}")
	public Department getDepartment(@PathVariable("department_id") long Id) {
		return departmentService.get_department(Id);
	}
	@PostMapping("create")
	public Department addemployee(@RequestBody CreateDepartment createDepartment) {
		return departmentService.add_department(createDepartment);
	}
	
	@DeleteMapping("delete/{department_id}")
	public void deleteEmployee(@PathVariable("department_id") long Id) {
		departmentService.delete_department(Id);
	}
}
