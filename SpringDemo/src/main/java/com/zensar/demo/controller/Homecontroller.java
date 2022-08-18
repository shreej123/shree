package com.zensar.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.demo.entity.Employee;
import com.zensar.demo.service.EmployeeService;


@RestController
//@RequestMapping("/controller")
public class Homecontroller {

	@Autowired
	EmployeeService empServ;
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id ) {
		System.out.println("Inside controller");
		
		return empServ.getEmployee(id);
		
	}
	
	@PostMapping("/register")
	public String registerEmployee(@RequestBody List<Employee> emp) {
		
		String returnString=empServ.registerEmp(emp);
		
		return returnString;
		
	}
	
	@GetMapping("/allEmployee")
	public List<Employee> getAllEmployee() {
		
		List<Employee> list=empServ.getAllEmployee();
		list.stream().forEach(System.out::println);
	
		return list;
	
	}
	
	@PutMapping("/update/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
		
		empServ.updateEmp(id,emp);
		
		return null;
		
	}
}

