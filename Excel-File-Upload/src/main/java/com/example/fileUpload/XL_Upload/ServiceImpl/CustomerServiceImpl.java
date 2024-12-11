package com.example.fileUpload.XL_Upload.ServiceImp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileUpload.XL_Upload.DTO.Customer;
import com.example.fileUpload.XL_Upload.Repo.CustomerRepository;
import com.example.fileUpload.XL_Upload.Service.ExcelUploadService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CustomerServiceImpl {
	@Autowired
	private CustomerRepository customerRepo;
	
	public void saveCustomers(MultipartFile file) {
		if(ExcelUploadService.isValidFile(file)) {
			try {
				List<Customer> customers = ExcelUploadService.getCustomerData(file.getInputStream());
				customerRepo.saveAll(customers);				
			}catch(IOException e) {
				throw new IllegalArgumentException("Not a valid Excel file");
			}
		}
	}
	
	public List<Customer> getCustomers(){
		return customerRepo.findAll();
	}
	
}
