package com.capgemini.exception;

public class CustomerDataAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//default constructor
	public CustomerDataAlreadyExistException() {
		super();
		// TODO Auto-generated constructor stub
	}


  //paramaterized constructor
	public CustomerDataAlreadyExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}



}
