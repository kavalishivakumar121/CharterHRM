/**
 * 
 */
package com.app.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hrm.dto.Charter_EmployeeDto;
import com.app.hrm.entity.Charter_EmployeeEntity;
import com.app.hrm.repo.Charter_EmployeeRepository;
import com.app.hrm.service.EmployeeRegisterService;

/**
 * skavali
 */
@RestController
public class Charter_EmployeeController {
	@Autowired
	private EmployeeRegisterService employeeService;
	
	@Autowired
	private Charter_EmployeeRepository repository;

	@GetMapping("/message")
	public String showMessage() {
		return "Hello workd";
	}
	
	@PostMapping("/signUp")
	public ResponseEntity<Charter_EmployeeDto> employeeRegister(@RequestBody Charter_EmployeeDto employeeDto){
		Charter_EmployeeDto registerEmployee = employeeService.registerEmployee(employeeDto);
		return new ResponseEntity<Charter_EmployeeDto>(registerEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("/employeeRecord")
	public ResponseEntity<String> getEmployeeRecord(Integer id){
		String result="Employee Record fetched successfully with Id :"+id;
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@GetMapping("/allEmployeeRecords")
	public ResponseEntity<String> getAllEmployees(Integer id){
		String result="All Employees fetched";
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@PutMapping("/updateRecord")
	public ResponseEntity<String> updateEmployeeRecord(Integer id){
		String result="Employee Record updated successful";
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	 @RequestMapping("/user")
	    public Charter_EmployeeEntity getUserDetailsAfterLogin(Authentication authentication) {
	        List<Charter_EmployeeEntity> employees = repository.findByEmail(authentication.getName());
	        if (employees.size() > 0) {
	            return employees.get(0);
	        } else {
	            return null;
	        }

	    }

}
