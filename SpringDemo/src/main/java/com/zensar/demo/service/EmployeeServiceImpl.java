package com.zensar.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zensar.demo.entity.Employee;
import com.zensar.demo.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
@Autowired
private EmployeeRepository empRepo;
	
	@Override
	public Optional<Employee> getEmployee(int id) {

		return empRepo.findById(id);
	}

	@Override
	public String registerEmp(List<Employee> emp) {
		String returnString;
		try{
			empRepo.saveAll(emp);
			 returnString="Employee saved successfully";
		}
		catch (Exception e) {
			returnString="Employee could not saved due to exception.."+e;
		}
	
		
		return returnString;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public String updateEmp(int id,Employee emp) {
		
		if(null!=empRepo.findById(id)) {
			Employee empl=new Employee();
			empl.setName(emp.getName());
			empl.setId(emp.getId());
			empRepo.save(empl);
		}
	
		return null;
	}

	
}
