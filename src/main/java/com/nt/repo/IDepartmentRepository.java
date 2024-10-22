package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.model.Dept;

@Repository("depRepo")
public interface IDepartmentRepository extends JpaRepository<Dept, Integer> {
	
	@Query("select deptno from Dept")
	public List<Integer> fetchAllDeptNos();
		
}
