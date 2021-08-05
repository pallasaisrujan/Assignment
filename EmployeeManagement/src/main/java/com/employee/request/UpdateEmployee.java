package com.employee.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateEmployee {

	private long emp_id;
	
	private String emp_name;
	
	private String emp_department;
	//private String emp_department;
	
}
