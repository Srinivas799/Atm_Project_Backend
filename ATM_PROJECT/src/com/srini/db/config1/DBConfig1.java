package com.srini.db.config1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig1 {
	private Connection con1;
	public Connection getConnection() {
		String url = "jdbc:mysql://@localhost:3306/atm";
		String user = "root";
		String password = "srinu";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con1 = DriverManager.getConnection(url,user,password);
			System.out.println("Data base connected successfully....");
			
			String query = "create table atmstore(Name varchar(50),"
					+ "AccountNumber bigint,"
					+ "Balance double,Status varchar(40))";
			
			Statement st = con1.createStatement();
			st.execute(query);
			System.out.println("Table Created Successfully....");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry change the jar file");
		}catch(SQLException e) {
			//System.out.println("Unable to connect with data base");
		}
		return con1;
	}
}
