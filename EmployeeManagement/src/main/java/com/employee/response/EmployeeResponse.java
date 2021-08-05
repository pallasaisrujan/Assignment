package com.employee.response;

import com.employee.model.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeResponse {

	private long Emp_id;
	
	private String Emp_Name;
	
	private long Age;
	
	private long Dep_id;
	
	private String Dep_Name;
	
	public EmployeeResponse(Employee employee) {
		this.Emp_id=employee.getId();
		this.Emp_Name=employee.getEmpName();
		this.Age=employee.getAge();
		this.Dep_id=employee.getDepartment_details().getId();
		this.Dep_Name=employee.getDepartment_details().getDepName();
	}
}
