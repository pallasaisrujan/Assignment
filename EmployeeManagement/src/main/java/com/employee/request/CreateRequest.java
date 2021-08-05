package com.employee.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateRequest {

	private String emp_name;
	
	private long emp_age;
	
	private String dep_name;
}
