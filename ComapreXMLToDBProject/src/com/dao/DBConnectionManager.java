package com.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;

public class DBConnectionManager implements DBConnectionUtil {

	Connection conn = null;

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = null;
		try {
			sc = new Scanner(new File("cofig.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String driver = "", url = "", uid = "", pass = "";
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String w[] = line.split(" ");
			driver = w[0];
			url = w[1];
			uid = w[2];
			pass = w[3];
		}
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, pass);
		if (!conn.isClosed()) {
			System.out.println("connection established successfully !!!");
		} else {
			System.out.println("connection is closed !!!");

		}
		return conn;
	}

	@Override
	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub

	}

}
