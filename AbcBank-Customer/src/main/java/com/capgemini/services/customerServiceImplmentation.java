package com.capgemini.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Customer;
import com.capgemini.repository.customerRepository;

@Service
public class customerServiceImplmentation implements customerService {

	
	private customerRepository cusRepo;
	
	private Customer customer;
	
	//public List<Customer>cusList=new ArrayList<Customer>();

	//constructor 
	public customerServiceImplmentation(customerRepository cusRepo) {
		super();
		this.cusRepo = cusRepo;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Customer saveCustomer=cusRepo.save(customer);
		return saveCustomer;
	}

	@Override
	public List getAllCustomer() {
		return cusRepo.findAll();

	}

	@Override
	public void deleteCustomer(int accountNumber) {
         cusRepo.deleteById(accountNumber);
		
	}


	
//	@Override
//	public Population updatePopulationData(Population pop) throws PopulationIdNotFound  {
//		// TODO Auto-generated method stub
//		Optional<Population> popDb = this.popRepo.findById(pop.getId());
//
//        if (popDb.isPresent()) {
//        	Population popUpdate = popDb.get();
//            popUpdate.setId(pop.getId());
//            popUpdate.setCity(pop.getCity());
//            popUpdate.setPop(pop.getPop());
//            popUpdate.setState(pop.getState());
//            popRepo.save(popUpdate);
//            return popUpdate;
//        }
//        else
//        {
//        	throw new PopulationIdNotFound();
//        }
//    }
//
	
	@Override
	public Customer updateCustomer(Customer customer) {
		
		Optional<Customer>custDb=this.cusRepo.findById(customer.getAccountNumber());
		if(custDb.isPresent())
		{
			
			Customer custUpdate=custDb.get();
			custUpdate.setAccountNumber(customer.getAccountNumber());
			custUpdate.setAccountName(customer.getAccountName());
			custUpdate.setAddress(customer.getAddress());
			custUpdate.setBalance(customer.getBalance());
			custUpdate.setBid(customer.getBid());
			cusRepo.save(custUpdate);
			return custUpdate;
		}
		else 
		{
			return null;
		}
		
	}

	@Override
	public Customer deposite(int amount) {

		Optional<Customer>custDb=this.cusRepo.findById(customer.getAccountNumber());
		if(custDb.isPresent())
		{
			
			Customer custUpdate=custDb.get();
			custUpdate.setAccountNumber(customer.getAccountNumber());
			custUpdate.setAccountName(customer.getAccountName());
			custUpdate.setAddress(customer.getAddress());
			custUpdate.setBalance(customer.getBalance()+amount);
			custUpdate.setBid(customer.getBid());
			cusRepo.save(custUpdate);
			return custUpdate;
		}
		else 
		{
			return null;
		}
	}

		@Override
		public Customer withdraw(int amount) {

			Optional<Customer>custDb=this.cusRepo.findById(customer.getAccountNumber());
			if(custDb.isPresent())
			{
				
				Customer custUpdate=custDb.get();
				custUpdate.setAccountNumber(customer.getAccountNumber());
				custUpdate.setAccountName(customer.getAccountName());
				custUpdate.setAddress(customer.getAddress());
				custUpdate.setBalance(customer.getBalance()-amount);
				custUpdate.setBid(customer.getBid());
				cusRepo.save(custUpdate);
				return custUpdate;
			}
			else 
			{
				return null;
			}
	
		}
}
	



