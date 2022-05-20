package com.cg.service;

import java.util.List;

import com.cg.exception.DataAlreadyExistsException;
import com.cg.exception.DataDoesNotExistsException;
import com.cg.model.EmployeeModel;

public interface EmployeeProfileService {

	public EmployeeModel addEmployeeDetails(EmployeeModel empd)throws DataAlreadyExistsException;
	public List<EmployeeModel> getallEmployeeDetails();
	public void deleteEmployee(int empd)throws DataDoesNotExistsException;
	public EmployeeModel updateEmployeeDetails(EmployeeModel uempd)throws DataDoesNotExistsException;
	
	
}
