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

import com.capgemini.model.Customer;
import com.capgemini.services.customerServiceImplmentation;

@RestController
@RequestMapping("/Customer")
public class customerController {

	@Autowired
	private customerServiceImplmentation cusImp;

	public customerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/post")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer cusSave = cusImp.addCustomer(customer);
		return new ResponseEntity<Customer>(cusSave, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return new ResponseEntity<List<Customer>>((List<Customer>) cusImp.getAllCustomer(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<Void> deleteFruit(@PathVariable int accountNumber) {
		cusImp.deleteCustomer(accountNumber);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
		customer.setAccountNumber(id);
		// pop.setId(id);

		// return ResponseEntity.ok().body(this.popService.updatePopulationData(pop));
		return ResponseEntity.ok().body(this.cusImp.updateCustomer(customer));

	}
	
	
	//for deposite
	@PutMapping("/deposite/{id}/{amount}")
	public ResponseEntity<Customer> deposite(@PathVariable int amount, @RequestBody Customer customer) {
		customer.setBalance(customer.getBalance()+amount);
		// pop.setId(id);
		

		// return ResponseEntity.ok().body(this.popService.updatePopulationData(pop));
		return ResponseEntity.ok().body(this.cusImp.updateCustomer(customer));

	}
	
	//for withdraw
	@PutMapping("/withdraw/{id}/{amount}")
	public ResponseEntity<Customer> withdraw(@PathVariable int amount, @RequestBody Customer customer) {
		customer.setBalance(customer.getBalance()-amount);
		// pop.setId(id);
		

		// return ResponseEntity.ok().body(this.popService.updatePopulationData(pop));
		return ResponseEntity.ok().body(this.cusImp.withdraw(amount));

	}

}
