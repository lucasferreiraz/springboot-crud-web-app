package io.lucasprojects.springbootcrudwebapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.lucasprojects.springbootcrudwebapp.model.Employee;

@Service
public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	public void saveEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	
	public void deleteEmployeeById(Long id);
}
