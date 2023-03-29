package com.srini.db.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig {
	private Connection con;
	public Connection getConnection() {
		String url = "jdbc:mysql://@localhost:3306/atm";
		String user = "root";
		String password = "srinu";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Data base connected successfully....");
			
			String query = "create table atmmoney(Name varchar(50),"
					+ "phoneNumber bigint,AccountNumber bigint,"
					+ "Address varchar(100),Password int,Balance double)";
			
			Statement st = con.createStatement();
			st.execute(query);
			System.out.println("Table Created Successfully....");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry change the jar file");
		}catch(SQLException e) {
			//System.out.println("Unable to connect with data base");
		}
		return con;
	}
}

