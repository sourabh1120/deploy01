package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgMtService;
import com.nt.validator.EmployeeValidation;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {

	
	
	@Autowired
	private IEmployeeMgMtService empService;
	
	@Autowired
	private EmployeeValidation empValidator;
	
	@GetMapping("/")
	public String showEmployee(){
		
		return "welcome";
	}
	
	/*
	 * @GetMapping("/report_pagination") public String
	 * showReportByPagination(Map<String, Object> map,
	 * 
	 * @PageableDefault(page=0,size=3,sort="ejob",direction=Sort.Direction.ASC)
	 * Pageable pageable) {
	 * 
	 * //get requested page data Page<Employee>
	 * page=empService.showEmployeeByPagination(pageable);
	 * 
	 * //keep Result as model attribute map.put("pageData", pageable); return
	 * "show_report_pagination"; }
	 */
	
	@GetMapping("/report")
	public String showEmpReport(Map<String,Object> map) {
		System.out.println("EmployeeOperationsController.showEmpReport()");
		List<Employee> empList=empService.fetchAllEmployees();
		map.put("empsInfo", empList);
		return "show_report";
	}
	
	
	@GetMapping("/register")
	public String showRegisterEmployee(@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOperationsController.showRegisterEmployeeFormPage()");
		return "employee_register_form";
		
	}
	
	/*
	 * @PostMapping("/register") public String processRegisterEmployee(Map<String,
	 * Object> map, @ModelAttribute("emp") Employee emp) { System.out.println(
	 * "EmployeeOperationsController.showRegisterEmployeeFormPage()"); //use service
	 * clas String msg=empService.registerEmployee(emp); List<Employee>
	 * list=empService.fetchAllEmployees(); map.put("resultMsg", msg);
	 * map.put("empsInfo", list); return "show_report";
	 * 
	 * }
	 */
	
	/*
	 * @PostMapping("/register") //prg pattern solve double posting problem public
	 * String processRegisterEmployee(Map<String, Object>
	 * map, @ModelAttribute("emp") Employee emp) { System.out.println(
	 * "EmployeeOperationsController.showRegisterEmployeeFormPage()"); //use service
	 * clas String msg=empService.registerEmployee(emp); // List<Employee>
	 * list=empService.fetchAllEmployees(); map.put("resultMsg", msg);
	 * //map.put("empsInfo", list); return "redirect:report";
	 * 
	 * }
	 */
	/*
	 * @PostMapping("/register") //prg pattern solve double posting problem + flash
	 * attribute public String processRegisterEmployee(RedirectAttributes
	 * attrs, @ModelAttribute("emp") Employee emp) { System.out.println(
	 * "EmployeeOperationsController.showRegisterEmployeeFormPage()"); //use service
	 * clas String msg=empService.registerEmployee(emp); // List<Employee>
	 * list=empService.fetchAllEmployees(); attrs.addFlashAttribute("resultMsg",
	 * msg); //map.put("empsInfo", list); return "redirect:report";
	 * 
	 * }
	 */
	

	@PostMapping("/register") //prg pattern solve double posting problem + flash attribute
	public String processRegisterEmployee(HttpSession ses, @ModelAttribute("emp") Employee emp
									,BindingResult errors) {
		System.out.println("EmployeeOperationsController.showRegisterEmployeeFormPage()");
		//enable server side form validation
		

		//use the validator
		if(empValidator.supports(emp.getClass())) {
			empValidator.validate(emp, errors);
			if(errors.hasErrors()) {
				return "employee_register_form";
			}
		}
		
		//application logic errror
		if(empService.isDesgInRejectList(emp.getEjob())) {
			errors.rejectValue("ejob","emp.desg.reject");
			return "employee_register_form";
		}
		
		String msg=empService.registerEmployee(emp);
	//	List<Employee> list=empService.fetchAllEmployees();
		ses.setAttribute("resultMsg", msg);
		//map.put("empsInfo", list);
		return "redirect:report";
	}

	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("no") int no,  @ModelAttribute("emp") Employee emp) {
		Employee emp1=empService.getEmployeeByNo(no);
		//keep emp1 model object data to emp
		BeanUtils.copyProperties(emp1, emp);
		return "employee_edit_form";
	}
	@PostMapping("/edit")
	public String processEditFormPage(RedirectAttributes attrs,  @ModelAttribute("emp") Employee emp
			,BindingResult errors) {
		//enable server side form validation when client side validation not done yet
	
		//use the validator
				if(empValidator.supports(emp.getClass())) {
					empValidator.validate(emp, errors);
					if(errors.hasErrors()) {
						return "employee_edit_form";
					}
				}
		
		String msg=empService.updateEmployee(emp);
		//keep emp1 model object data to emp
		
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String showDeleteEmployee(@RequestParam("no") int no, RedirectAttributes attrs) {
		//use service
		String msg=empService.deleteEmployee(no);
		//keep the result in modelAttribute
		attrs.addFlashAttribute("resultMsg",msg);
		
		return "redirect:report";
	}
	//method of reference data holding the dept names
	
	@ModelAttribute("dnoList")
	public List<Integer> populateDeptNos(){
		List<Integer>  dnList=empService.showAllDeptNos();
		return dnList;
		
	}
}
