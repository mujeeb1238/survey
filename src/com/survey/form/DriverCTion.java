package com.survey.form;

import java.sql.Connection;
import java.sql.DriverManager;

public class DriverCTion {
	
	Connection connection;
	
		public Connection getconnections() throws Exception{
		
		String driver="org.sqlite.JDBC";
		String url="jdbc:sqlite:/home/ashokreddy/survey";
		
		Class.forName(driver);
		connection = DriverManager.getConnection(url);
		return connection;

	}

}
