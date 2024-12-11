package com.example.fileUpload.XL_Upload.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fileUpload.XL_Upload.DTO.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
