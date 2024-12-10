package com.csi.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	List<Employee> employees = Stream.of(new Employee(121, "SWARA", 98000), new Employee(123, "ANKITA", 98000),
			new Employee(132, " MADHAVI", 78000), new Employee(155, "BHUMI", 80000), new Employee(150, "NEHA", 60000))
			.toList();

	@GetMapping("/sortbyid")
	public List<Employee> sortById() {
		return employees.stream().sorted(Comparator.comparing(Employee::getEmpId)).toList();
	}
	
	@GetMapping("/sortbyiddesc")
	public List<Employee> sortByIdDesc() {
		return employees.stream().sorted(Comparator.comparing(Employee::getEmpId).reversed()).toList();
	}
	
	@GetMapping("/sortbyname")
	public List<Employee>sortByName(){
		return employees.stream().sorted(Comparator.comparing(Employee::getEmpName)).toList();
		
		
	}

	
	@GetMapping("/sortbysalary")
	public List<Employee>sortBySalary(){
		return employees.stream().sorted(Comparator.comparing(Employee::getEmpsalary).reversed()).toList();
			
	}	
	
	
}
