package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.EmployeeModel;
import com.cg.service.EmployeeProfileService;

@RestController
@RequestMapping("/api/pro")
public class EmployeeProfileController {
	
	private EmployeeProfileService service;
	
	@Autowired
	public EmployeeProfileController(EmployeeProfileService emps) {
		super();
		this.service = emps;
	}
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeModel> addEmployee(@RequestBody  EmployeeModel empadd) throws DataAlreadyExistsException{
		EmployeeModel empsave=service.addEmployeeDetails(empadd);
		return new ResponseEntity<>(empsave,HttpStatus.CREATED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<EmployeeModel>> Employee(){
	return new ResponseEntity<List<EmployeeModel>>((List<EmployeeModel>)service.getallEmployeeDetails(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empID}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable int empID)throws DataDoesNotExistsException{
		service.deleteEmployee(empID);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/update")
	public EmployeeModel updateEmployee(@RequestBody EmployeeModel empu) throws DataDoesNotExistsException {
		return service.updateEmployeeDetails(empu);
		
	}
	

}
