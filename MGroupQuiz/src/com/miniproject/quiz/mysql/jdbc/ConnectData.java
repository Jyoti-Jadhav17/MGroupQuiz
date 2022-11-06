package com.miniproject.quiz.mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// creating utility class for connection
public class ConnectData {

	// creating utility method for database connection
	public static Connection getConnection() {
		// using try catch for exception handaling
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Exception>> Class is not found");
		}
		String url = "jdbc:mysql://localhost:3306/javaQuiz?characterEncoding=utf8";
		String name = "root";
		String password = "root";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, name, password);

		} catch (SQLException e) {
			System.out.println("Connection not established");
		}
		return con;
	}

}
