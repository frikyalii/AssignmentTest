package com.capgemini.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.model.Branch;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class branchRepositoryTest {

	@Autowired
	private branchRepository branchRepo;
	
	
	
	@Test
	public void givenBranchObject()  {
		Branch b1=new Branch(121,"1213","pune");     //userr input
		branchRepo.save(b1);       //save in data base
		Branch b2=branchRepo.findById(b1.getBid()).get();
		assertNotNull(b2);
		assertEquals(b1.getBid(),b2.getBid());
	}
	
	@Test
	public void getAllMustReturnAllBranch()
	{
		
		List<Branch> branchList = (List<Branch>) branchRepo.findAll();  //user input in the form of list
		//assertEquals("pune",cusList.get(0).getAddress());
		assertEquals("mumbai",branchList.get(0).getLocation());

	}

}
