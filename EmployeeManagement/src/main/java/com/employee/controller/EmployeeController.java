package com.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.request.CreateRequest;
import com.employee.request.UpdateEmployee;
import com.employee.response.EmployeeResponse;
import com.employee.service.EmployeeService;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;


@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("getemployees/{employee_id}")
	public EmployeeResponse getemployees(@PathVariable("employee_id") long Id) {
		return new EmployeeResponse(employeeService.get_employees(Id));
	}
	
	@GetMapping("getsortedemployees")
	public List<Employee> getsortedemployees(){
		List<Employee> sortedList=employeeService.sortEmployee();
		return sortedList;
	}
	@GetMapping("getemployeesWithPagination")
	public List<Employee> getWithPagination(@RequestParam int pageNo,@RequestParam int pageSize){
		List<Employee> employeeList=employeeService.displayWithPagination(pageNo,pageSize);
		return employeeList;
	}
	
	
	@PostMapping("create")
	public Employee addemployee(@RequestBody CreateRequest createRequest) {
		Employee employee= employeeService.add_employee(createRequest);
		return employee;
	}
	
	@PutMapping("change")
	public Employee updateEmployee(@RequestBody UpdateEmployee updateEmployee) {
		return employeeService.update_employee(updateEmployee);
	}
	
	@DeleteMapping("delete/{employee_id}")
	public void deleteEmployee(@PathVariable("employee_id") long Id) {
		employeeService.delete_employee(Id);
	}
	
	
}
