package com.util;

import java.util.*;
import java.io.*;
import java.sql.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.w3c.dom.*;

import com.app.bean.*;
import com.dao.*;

public class CompareData {
	List<Employee> xmlEmployeeList = new ArrayList<Employee>();
	List<Employee> DBEmployeeList = new ArrayList<Employee>();
	Connection conn;

	List<Employee> populateXMLData(String xmlFilePath) {
		System.out.println("xmlFilePath : " + xmlFilePath);

		List<Employee> xmlEmployeeList = new ArrayList<Employee>();
		try {
			File inputFile = new File(xmlFilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// x = dBuilder.parse(inputFile);
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("employee");
			System.out.println("----------------------------");
			// System.out.println(nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				// System.out.println("\nCurrent Element :" +
				// nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Employee e = new Employee();

					Element eElement = (Element) nNode;
					// System.out.println("Element : " + eElement);

					String empID = eElement.getElementsByTagName("empID").item(0).getTextContent();
					e.setId(empID);

					String empName = eElement.getElementsByTagName("empName").item(0).getTextContent();
					e.setName(empName);

					String empDesignation = eElement.getElementsByTagName("empDesignation").item(0).getTextContent();
					e.setDesignation(empDesignation);

					xmlEmployeeList.add(e);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlEmployeeList;
	}

	List<Employee> populateDBData() {

		List<Employee> DBEmployeeList = new ArrayList<Employee>();

		// Connection conn;
		try {
			DBConnectionManager dbm = new DBConnectionManager();
			conn = dbm.getConnection();

			Statement statement = conn.createStatement();
			String s = "SELECT * FROM employees";

			ResultSet rs = statement.executeQuery(s);
			// int g = 0;

			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getString("EMPID"));
				e.setName(rs.getString("EMPNAME"));
				e.setDesignation(rs.getString("EMPDESIGNATION"));

				DBEmployeeList.add(e);
			}

			rs.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return DBEmployeeList;

	}

	void storeDataInExcelSheet(List<?> objectList, String fileName, String SheetName) {
		// String excelFilePath = "JavaBooks.xlsx";
		updateSheet excelWriter = new updateSheet();

		try {
			excelWriter.writeExcel(objectList, fileName, SheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	List<EmployeePrototype> compareData(List<Employee> xmlDataList, List<Employee> dbDataList) {

		List<EmployeePrototype> resultList = new ArrayList<EmployeePrototype>();
		Iterator<Employee> xmlIt = xmlDataList.iterator();
		Iterator<Employee> dbIt = dbDataList.iterator();

		if (xmlDataList.size() == dbDataList.size()) {
			EmployeePrototype empProt = new EmployeePrototype();
			while (xmlIt.hasNext() && dbIt.hasNext()) {
				empProt = compareRes(xmlIt.next(), dbIt.next());
				resultList.add(empProt);
			}

		} else if (xmlDataList.size() < dbDataList.size()) {
			EmployeePrototype empProt = new EmployeePrototype();
			int i = 0;
			while (xmlIt.hasNext() && dbIt.hasNext()) {
				i++;
				empProt = compareRes(xmlIt.next(), dbIt.next());
				resultList.add(empProt);
			}

			for (int j = 0; j < Math.abs(dbDataList.size() - i); j++) {
				EmployeePrototype empProt1 = new EmployeePrototype("NA", "NA", "NA");
				resultList.add(empProt1);
			}
		} else if (xmlDataList.size() > dbDataList.size()) {
			EmployeePrototype empProt = new EmployeePrototype();
			int i = 0;

			while (dbIt.hasNext() && xmlIt.hasNext()) {
				i++;
				empProt = compareRes(xmlIt.next(), dbIt.next());
				resultList.add(empProt);
			}

			for (int j = 0; j < Math.abs(xmlDataList.size() - i); j++) {
				EmployeePrototype empProt1 = new EmployeePrototype("NA", "NA", "NA");
				resultList.add(empProt1);
			}

		}
		return resultList;
	}

	private EmployeePrototype compareRes(Employee empXml, Employee empDb) {
		// TODO Auto-generated method stub
		// ArrayList<String> arr = new ArrayList<String>();
		EmployeePrototype empProt = new EmployeePrototype();

		if (empXml.getId().toString().equals(empDb.getId().toString())) {
			empProt.setId("YES");
			// System.out.println("YES");
		} else {
			empProt.setId("NO");
			// System.out.println("NO");
		}

		if (empXml.getName().toString().equals(empDb.getName().toString())) {
			empProt.setName("YES");
			// System.out.println("YES");
		} else {
			empProt.setName("NO");
			// System.out.println("NO");
		}

		if (empXml.getDesignation().toString().equals(empDb.getDesignation().toString())) {
			empProt.setDesignation("YES");
			// System.out.println("YES");
		} else {
			empProt.setDesignation("NO");
			// System.out.println("NO");
		}

		return empProt;
	}

	public void performComparison(String xmlFilePath, String workSheetName) {

		List<Employee> xmlEmployeeList;
		List<Employee> dbEmployeeList;
		List<EmployeePrototype> resultList;

		xmlEmployeeList = populateXMLData(xmlFilePath);
		dbEmployeeList = populateDBData();

		storeDataInExcelSheet(xmlEmployeeList, workSheetName, "xml");
		storeDataInExcelSheet(dbEmployeeList, workSheetName, "db");

		resultList = compareData(xmlEmployeeList, dbEmployeeList);

		storeDataInExcelSheet(resultList, workSheetName, "result");
	}

}// CompareData
