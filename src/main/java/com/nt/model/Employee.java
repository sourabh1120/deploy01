package com.nt.model;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name="boot_emp")
@SQLDelete(sql="UPDATE BOOT_EMP SET STATUS ='deleted' WHERE EMPNO=?")
@Where(clause="STATUS <> 'deleted'")
public class Employee implements Serializable{

	@Id
	@SequenceGenerator(name="gen1" ,sequenceName = "EMP_ID_SEQ",initialValue = 1,allocationSize = 10000)
	@GeneratedValue(generator ="gen1", strategy = GenerationType.AUTO)
	private Integer empno;
	private String ename;
	private String ejob="manager";
	private Double esalary;
	private Integer edeptno;
	private String status="active";
	private Integer deptno; 
	//@Transient
	//private String vflag1="no";
}
