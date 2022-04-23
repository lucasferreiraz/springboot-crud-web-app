package io.lucasprojects.springbootcrudwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.lucasprojects.springbootcrudwebapp.model.Employee;
import io.lucasprojects.springbootcrudwebapp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; 
	
	@GetMapping(path = "/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		
		return "index";
	}
	
	@GetMapping(path = "/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model){
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "newEmployee";
	}
	
	@PostMapping(path = "/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employe) {
		employeeService.saveEmployee(employe);
		return "redirect:/";
	}
	
	@GetMapping(path = "/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model ) {
		
		Employee employee = employeeService.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		
		return "updateEmployee";
		
	}
	
	@GetMapping(path = "/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long id) {
		
		employeeService.deleteEmployeeById(id);
		
		
		return "redirect:/";
	}
}
