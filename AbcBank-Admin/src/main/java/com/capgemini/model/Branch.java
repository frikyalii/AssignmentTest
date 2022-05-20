package com.capgemini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Branch")
public class Branch {

	@Id
	private int bid;
	private String bcode;
	private String location;

	public Branch(int bid, String bcode, String location) {
		super();
		this.bid = bid;
		this.bcode = bcode;
		this.location = location;
	}

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Branch [bid=" + bid + ", bcode=" + bcode + ", location=" + location + "]";
	}

}
