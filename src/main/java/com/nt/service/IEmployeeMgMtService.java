package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.model.Employee;


public interface IEmployeeMgMtService {
	public List<Employee> fetchAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeByNo(int no);
	public String updateEmployee(Employee emp);
	public String deleteEmployee(int no);
	public List<Integer> showAllDeptNos();
	boolean isDesgInRejectList(String desg);
//	public Page<Employee> showEmployeeByPagination(Pageable pageable);
}
