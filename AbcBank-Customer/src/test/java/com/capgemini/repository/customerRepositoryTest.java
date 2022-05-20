package com.capgemini.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.model.Customer;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class customerRepositoryTest {

	
	@Autowired
	private customerRepository custRepo;
	
	
	
	@Test
	public void givenCustomerObject()  {
		Customer c1=new Customer(121,"asad","momin galli",1213,1,"1213");
		custRepo.save(c1);
		Customer c2=custRepo.findById(c1.getAccountNumber()).get();
		assertNotNull(c2);
		assertEquals(c1.getAccountName(),c2.getAccountName());
	}

}
