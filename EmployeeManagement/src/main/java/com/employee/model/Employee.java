package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.employee.request.CreateRequest;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="emp")
public class Employee {

	public Employee(CreateRequest createRequest) {
		this.EmpName=createRequest.getEmp_name();
		this.Age=createRequest.getEmp_age();
		//department_details.setDepName(createRequest.getDep_name());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private long Id;
	
	@Column(name="employee_name")
	private String EmpName;
	
	@Column(name="employee_age")
	private long Age;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department_details;
}
