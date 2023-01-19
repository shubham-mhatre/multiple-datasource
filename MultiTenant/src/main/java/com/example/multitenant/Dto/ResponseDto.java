package com.example.multitenant.Dto;

import java.io.Serializable;
import java.util.List;


public class ResponseDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<com.example.multitenant.pract.model.Client> practDb;
	List<com.example.multitenant.pract1.model.Client> practDb1;
	
	public List<com.example.multitenant.pract.model.Client> getPractDb() {
		return practDb;
	}
	public void setPractDb(List<com.example.multitenant.pract.model.Client> practDb) {
		this.practDb = practDb;
	}
	public List<com.example.multitenant.pract1.model.Client> getPractDb1() {
		return practDb1;
	}
	public void setPractDb1(List<com.example.multitenant.pract1.model.Client> practDb1) {
		this.practDb1 = practDb1;
	}
	
	

}
