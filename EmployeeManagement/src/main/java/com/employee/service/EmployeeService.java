package com.employee.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.request.CreateRequest;
import com.employee.request.UpdateEmployee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	public Employee get_employees(long id) {

		return employeeRepository.findById(id).get();
	}

	public Employee add_employee(CreateRequest createRequest) {
		Employee employee = new Employee();
		List<Department> dept_lists = departmentRepository.getByDepName(createRequest.getDep_name());

		if (dept_lists.isEmpty()) {

			Department department = new Department();
			department.setDepName(createRequest.getDep_name());
			departmentRepository.save(department);
			employee.setEmpName(createRequest.getEmp_name());
			employee.setAge(createRequest.getEmp_age());
			employee.setDepartment_details(department);
			employeeRepository.save(employee);

		} else {

			employee.setEmpName(createRequest.getEmp_name());
			employee.setAge(createRequest.getEmp_age());
			System.out.println(dept_lists.get(0));
			employee.setDepartment_details(dept_lists.get(0));
			employeeRepository.save(employee);
			return employee;

		}
		return employee;
		/*
		 * Employee employee=new Employee(createRequest); employee=
		 * employeeRepository.save(employee); Department department=new Department();
		 * List<Department> dept_lists=departmentRepository.findAll(); int flag=0;
		 * for(Department dept:dept_lists) {
		 * if(dept.getDepName().equalsIgnoreCase(createRequest.getDep_name())) { flag=1;
		 * } } if()
		 * 
		 * 
		 * if(createRequest.getDep_name()!=" ") {
		 * department.setDepName(createRequest.getDep_name());
		 * departmentRepository.save(department); }
		 * employee.setDepartment_details(department); return employee;
		 */
	}

	public Employee update_employee(UpdateEmployee updateEmployee) {
		Employee employee = employeeRepository.findById(updateEmployee.getEmp_id()).get();
		List<Department> departmentlist = departmentRepository.getByDepName(updateEmployee.getEmp_department());
		Department department = new Department();
		if (departmentlist.isEmpty()) {
			department.setDepName(updateEmployee.getEmp_department());
			System.out.println(updateEmployee.getEmp_department());
			departmentRepository.save(department);
			employee.setEmpName(updateEmployee.getEmp_name());
			employee.setDepartment_details(department);
			employee = employeeRepository.save(employee);
		} else {
			employee.setEmpName(updateEmployee.getEmp_name());
			employee.setDepartment_details(departmentlist.get(0));
			employee = employeeRepository.save(employee);
		}
		return employee;
	}

	public void delete_employee(long id) {
		employeeRepository.deleteById(id);

	}

	public List<Employee> displayWithPagination(int pageNo, int pageSize) {
		
		Pageable pageable=PageRequest.of(pageNo-1,pageSize);
		return employeeRepository.findAll(pageable).getContent();
	}

	public List<Employee> sortEmployee() {
		Sort sort=Sort.by(Sort.Direction.ASC, null);
		
		return employeeRepository.findAll(sort);
	}

}
