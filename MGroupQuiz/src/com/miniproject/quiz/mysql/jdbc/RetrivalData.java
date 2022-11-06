package com.miniproject.quiz.mysql.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.miniproject.quiz.java.*;
import com.miniproject.quiz.main.*;

public class RetrivalData {
	static int id;

	public static void resultAllRetriveData() {
// to retrive all data fram data base
		Connection con = ConnectData.getConnection();
		String sql = "Select * from studentdetails ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				System.out.println("ID>> " + rs.getInt(1));
				System.out.println("NAME>> " + rs.getString(2));
				System.out.println("Score>> " + rs.getInt(3));
				System.out.println("----------------------------------------------------");
				System.out.println();
				
			}
			// ps.close();

		} catch (SQLException e) {
			System.out.println("Exception caused during retrival data");
		}

	}

	public static void idScoreRetival() {
		// to retrive any particalur result of any id ..
		System.out.println("Enter ID number  if u want to see any particular result>>");
		Scanner sc = new Scanner(System.in);

		boolean flag = sc.hasNextInt();

		do {

			if (sc.hasNextInt()) {
				id = sc.nextInt();
				flag = true;
			} else {
				System.out.println("Enter correct ID ...Id should have only numbers..");
				flag = false;
				sc.next();
			}

		} while (flag == false);

		Connection con = ConnectData.getConnection();
		String sql = "Select * from studentdetails where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			// boolean flag =ps.execute();

			ResultSet rs = ps.executeQuery();
			
			
				while (rs.next()) {
					
					System.out.println("Score>>" + rs.getInt(3));
					if (ps.isPoolable()) {
				}
					else {
						System.out.println("Sorry ...This ID doesnt exist...");
					}
				// ps.close();

			} 
		} catch (SQLException e) {
			System.out.println("Exception caused during retrival data");
		}
		// sc.close();
	}

	public static void showResult() {

		System.out.println();
		System.out.println("Do u want  fetch all students result:");
		System.out.println("If yes press Y");
		System.out.println("IF no press N");

		Scanner sc = new Scanner(System.in);
		String ch = sc.next();
		while (true)
			if (ch.compareToIgnoreCase("y") == 0) {
				resultAllRetriveData();
				break;
			} else if (ch.compareToIgnoreCase("n") == 0) {
				idScoreRetival();
				break;
			} else {
				while (true) {
					System.out.println("You entered invalid input...");
					System.out.println("Enter the key Y or N only");
					ch = sc.next();
					if (ch.compareToIgnoreCase("y") == 0 || ch.compareToIgnoreCase("n") == 0) {
						break;

					}

				}
			}
		// sc.close();
	}

	
}
