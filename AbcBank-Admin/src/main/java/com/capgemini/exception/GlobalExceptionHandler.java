package com.capgemini.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Value(value = "${data.exception.dataExists}")
	private String dataExists;

	@ExceptionHandler(value = CustomerDataAlreadyExistException.class)
	public ResponseEntity<String> CustomerDataAlreadyExistException(CustomerDataAlreadyExistException cdae) {
		return new ResponseEntity<String>(dataExists, HttpStatus.CONFLICT);

	}

	@Value(value = "${data.exception.dataNotFound}")
	private String dataNotFound;

	@ExceptionHandler(value = BranchAlreadyExistException.class)
	public ResponseEntity<String> BranchAlreadyExistException(BranchAlreadyExistException cdae) {
		return new ResponseEntity<String>(dataNotFound, HttpStatus.CONFLICT);

	}

	@Value(value = "${data.exception.dataNotFoundForCorrespondingId}")
	private String dataNotFoundForCorrespondingId;

	@ExceptionHandler(value = BranchIdNotFoundException.class)
	public ResponseEntity<String> BranchIdNotFoundException(BranchIdNotFoundException cdae) {
		return new ResponseEntity<String>(dataNotFoundForCorrespondingId, HttpStatus.CONFLICT);

	}

}
