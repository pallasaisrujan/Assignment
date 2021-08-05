package com.employee.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.employee.request.CreateRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="dep")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	private long Id;
	
	@Column(name="department_name")
	private String DepName;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "department_details")
	private List<Employee> empList;
	
	public Department(CreateRequest createRequest) {
		this.DepName=createRequest.getDep_name();
		
	}
}
