package com.zensar.demo.service;

import java.util.List;
import java.util.Optional;

import com.zensar.demo.entity.Employee;

public interface EmployeeService {

	public Optional<Employee> getEmployee(int id);

	public String registerEmp(List<Employee> emp);

	public List<Employee> getAllEmployee();

	public String updateEmp(int id, Employee emp);

}
