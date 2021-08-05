package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.model.Department;
import com.employee.model.Employee;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	@Query("From Department where DepName=?1")
	List<Department> getByDepName(String emp_department);
	
}
