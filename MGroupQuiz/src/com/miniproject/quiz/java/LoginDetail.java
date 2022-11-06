package com.miniproject.quiz.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import com.miniproject.quiz.mysql.jdbc.ConnectData;

public class LoginDetail {
	static int id ;
	static String name;
	
	public static void studentInfo() {
// taking name and id from student 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id>>");
	//if user enter wrong input other than integer
		boolean flag = sc.hasNextInt();

		do {

			if (sc.hasNextInt()) {
				id = sc.nextInt();
				flag = true;
			} else {
				System.out.println("Enter correct ID ...Id should have only numbers");
				flag = false;
				sc.next();
			}

		} while (flag == false);
		
		
//	if that enter id already exist then it will throw custom exception
		try {
			Connection con = ConnectData.getConnection();
			String sql = "Select * from studentdetails where id";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==id) {
					throw new ExceptionId("Your ID Already Exist.....You Have Already Login with this ID");
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException occurs during id insertion in database");
		}
		
		System.out.println("Enter your name>>");
		sc.nextLine();
		 name = sc.nextLine();

		 System.out.println("Do you want to start the Quiz..");
		 System.out.println("Enter any letter to start the Quiz..");
		 sc.next();
		 System.out.println();
		// sc.close();
	}
	

	public static void addStudentInfo() {
	// inserting id ,name , result into data base table studentdetails..
		
		Connection con = ConnectData.getConnection();
		String sqlQuery = "insert into studentdetails ( id,name,result_score) values(?,?,?);";
		
		try {
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			
			ps.setInt(1, id);
			ps.setString(2, name);
		    ps.setInt(3, InputData.result);

			int noOfRowsAffeccted = ps.executeUpdate();
			 System.out.println("noOfRowsAffeccted>>"+noOfRowsAffeccted);
		//	 ps.close();

		} catch (SQLException e1) {
			System.out.println("SQLException cause during data insertion into StudentDetails table");
			
		}

	}

	
}
