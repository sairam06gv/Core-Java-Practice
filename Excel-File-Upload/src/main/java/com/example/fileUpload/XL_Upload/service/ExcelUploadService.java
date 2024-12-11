package com.example.fileUpload.XL_Upload.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileUpload.XL_Upload.DTO.Customer;

public class ExcelUploadService {

	public static boolean isValidFile(MultipartFile file) {
		return Objects.equals(file.getContentType(),
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}

	public static List<Customer> getCustomerData(InputStream inputstream) throws IOException {

		List<Customer> customers = new ArrayList<>();

		try {
			XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
			XSSFSheet sheet = workbook.getSheet("customers");
			int rowIndex = 0;

			for (Row row : sheet) {

				if (rowIndex == 0) {
					rowIndex++;
					continue;
				}

				Iterator<Cell> iterator = row.iterator();
				int cellIndex = 0;

				Customer customer = new Customer();

				while (iterator.hasNext()) {
					Cell cell = iterator.next();
					switch (cellIndex) {
					case 0 -> customer.setCustomerId((int) cell.getNumericCellValue());
					case 1 -> customer.setFirstName(cell.getStringCellValue());
					case 2 -> customer.setLastName(cell.getStringCellValue());
					case 3 -> customer.setCountry(cell.getStringCellValue());
					case 4 -> customer.setTelephone((int) cell.getNumericCellValue());
					default -> {
					}
					}
					cellIndex++;
				}
				customers.add(customer);
			}
			workbook.close();

		} catch (IOException e) {
			e.getStackTrace();
		}finally {
			inputstream.close();
		}

		return customers;
	}

}
