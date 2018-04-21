package com.util;

import java.util.*;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.app.bean.*;

/**
 * A very simple program that writes some data to an Excel file using the Apache
 * POI library.
 * 
 * @author www.codejava.net
 *
 */
public class updateSheet {

	private void writeObject(Object ob, Row row) {
		// Cell cell = row.createCell(1);
		if (ob instanceof Employee) {
			Employee employee = (Employee) ob;
			row.createCell(1).setCellValue(employee.getId());

			// Cell cell = row.createCell(2);
			row.createCell(2).setCellValue(employee.getName());

			// Cell cell = row.createCell(3);
			row.createCell(3).setCellValue(employee.getDesignation());
		} else if (ob instanceof EmployeePrototype) {
			EmployeePrototype employeeProt = (EmployeePrototype) ob;
			row.createCell(1).setCellValue(employeeProt.getId());

			// Cell cell = row.createCell(2);
			row.createCell(2).setCellValue(employeeProt.getName());

			// Cell cell = row.createCell(3);
			row.createCell(3).setCellValue(employeeProt.getDesignation());
		}

	}

	public void writeExcel(List<?> objectList, String excelFilePath, String sheetName) throws IOException {
//		Workbook workbook = new HSSFWorkbook();
//		Sheet sheet = workbook.createSheet();

		// XSSFWorkbook workbook = new XSSFWorkbook();
		// //Create a blank spreadsheet
		// XSSFSheet spreadsheet = workbook.createSheet("Sheet Name");
		
		 FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         
	     Workbook workbook = new HSSFWorkbook(inputStream);
	     
	     if (workbook.getSheet(sheetName) != null)
	     {
	    	 workbook.removeSheetAt(workbook.getSheetIndex(sheetName));
	     }
	     Sheet sheet = workbook.createSheet(sheetName);
		
		int rowCount = 0;

		for (Object ob : objectList) {
			Row row = sheet.createRow(++rowCount);
			writeObject(ob, row);
		}

		try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
			workbook.write(outputStream);
		}
	}

	public static void main(String[] args) throws IOException {
		updateSheet excelWriter = new updateSheet();
	}

}