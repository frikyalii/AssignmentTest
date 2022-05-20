package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.BranchAlreadyExistException;
import com.capgemini.model.Branch;
import com.capgemini.services.branchServiceImplementaion;

@RestController
@RequestMapping("/Branch")
public class branchController {

	@Autowired
	private branchServiceImplementaion branchSer;

	public branchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/postBranch")
	public ResponseEntity<Branch> addBranch(@RequestBody Branch branch)throws BranchAlreadyExistException {
		Branch branchSave = branchSer.addBranch(branch);
		return new ResponseEntity<Branch>(branchSave, HttpStatus.CREATED);

	}

	@GetMapping("/getBranch")
	public ResponseEntity<List<Branch>> getBranch() {
		return new ResponseEntity<List<Branch>>((List<Branch>) branchSer.getAllBranch(), HttpStatus.OK);

	}

	@DeleteMapping("/deleteBranch/{bid}")
	public ResponseEntity<Void> deleteBranchById(@PathVariable int bid) {
		branchSer.deleteBranch(bid);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/updateBranch/{id}")
	public ResponseEntity<Branch> updateBranch(@PathVariable int id, @RequestBody Branch branch) {
		branch.setBid(id);
		return ResponseEntity.ok().body(this.branchSer.updateBranch(branch));

	}

}
