package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component
public class EmployeeValidation implements Validator {


	@Override
	public boolean supports(Class<?> clazz) {//checks whether correct Model class has come or not
		
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//typeCast to model class
		Employee emp=(Employee)target;
		//write server side form validation logics
		if(emp.getEname().equals("")|| emp.getEname().length()==0) {
			errors.rejectValue("ename","emp.name.required");
		}else if(emp.getEname().length()<5 || emp.getEname().length()>15) {
			errors.rejectValue("ename","emp.name.length");
		}

		if(emp.getEjob().equals("")|| emp.getEjob().length()==0) {
			errors.rejectValue("ejob","emp.job.required");
		}else if(emp.getEjob().length()<4 || emp.getEjob().length()>10){
			errors.rejectValue("ejob","emp.job.length");
		}
		
		if(!errors.hasFieldErrors("esalary")) {
			if(emp.getEsalary()==null) {
				errors.rejectValue("esalary","emp.sal.required");
			}else if(emp.getEsalary()<10000 ||emp.getEsalary()>200000){
				errors.rejectValue("esalary","emp.sal.range");
			}
		}
		
		if(emp.getEdeptno()==null) {
			errors.rejectValue("edeptno","emp.deptno.required");
		}
		

	}

}
