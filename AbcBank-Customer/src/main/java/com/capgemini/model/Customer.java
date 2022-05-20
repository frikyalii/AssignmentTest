package com.capgemini.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer {
	
	@Id
	private int accountNumber;
	private String accountName;
	private String address;
	private int balance;
	private int bid;
	private String password;
	

	
	public Customer(int accountNumber, String accountName, String address, int balance, int bid, String password) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.address = address;
		this.balance = balance;
		this.bid = bid;
		this.password = password;
	}
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", accountName=" + accountName + ", address=" + address
				+ ", balance=" + balance + ", bid=" + bid + ", password=" + password + "]";
	}
	
	

}
