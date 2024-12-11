package com.example.fileUpload.XL_Upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.fileUpload.XL_Upload.Repo")
@EntityScan(basePackages = "com.example.fileUpload.XL_Upload.DTO")
@SpringBootApplication
public class XlUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(XlUploadApplication.class, args);
	}

}
