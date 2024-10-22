package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empRepo")
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
