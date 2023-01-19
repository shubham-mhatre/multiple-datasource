package com.example.multitenant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.multitenant.Dto.ResponseDto;
import com.example.multitenant.config.ConfigurationPropDemo;
import com.example.multitenant.pract.repo.ClientRepo;
import com.example.multitenant.pract1.repo.UserRepo;

@RestController
public class WebController {

	@Autowired private UserRepo pract1ClientRepo;
	@Autowired private ClientRepo practDbClientRepo ;
	@Autowired private ConfigurationPropDemo configPropDemo;
	
	@GetMapping("/getAll")
	public ResponseDto getAll() {
		ResponseDto resp = new ResponseDto();
		resp.setPractDb(practDbClientRepo.findAll());
		resp.setPractDb1(pract1ClientRepo.findAll());
		
		System.out.println("configPropDemo "+configPropDemo);
		
		return resp;
	}
}
