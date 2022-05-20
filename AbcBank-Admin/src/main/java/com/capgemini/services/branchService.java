package com.capgemini.services;

import java.util.List;

import com.capgemini.exception.BranchAlreadyExistException;
import com.capgemini.model.Branch;

public interface branchService {
	
	public Branch addBranch(Branch branch) throws BranchAlreadyExistException;

	public List getAllBranch();

	public void deleteBranch(int bid);
	
	public Branch updateBranch(Branch branch);

}
