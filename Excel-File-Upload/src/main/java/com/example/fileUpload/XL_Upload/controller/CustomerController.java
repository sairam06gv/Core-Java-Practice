package com.example.fileUpload.XL_Upload.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileUpload.XL_Upload.DTO.Customer;
import com.example.fileUpload.XL_Upload.ServiceImp.CustomerServiceImpl;


@RestController

@RequestMapping(value="/customers")
public class CustomerController {
	
    @Autowired
	private CustomerServiceImpl customerService;
	
	@PostMapping("/uploadCustomerData")
	public ResponseEntity<?> uploadCustomerData(@RequestParam("file")MultipartFile file){
		
		customerService.saveCustomers(file);
		return ResponseEntity.ok(Map.of("Message","Customer data uploaded and saved to db"));
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getCustomers(){
		return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.FOUND);
		
	}
	

}
