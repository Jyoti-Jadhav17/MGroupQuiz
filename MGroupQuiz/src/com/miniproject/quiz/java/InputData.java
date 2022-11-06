package com.miniproject.quiz.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.miniproject.quiz.mysql.jdbc.ConnectData;

public class InputData {
	static int result = 0;

	static Map<Questions, String> map = new HashMap<>();

// insering key-(Questions+options) and value -(correctAnswer);

	public static void quiz() {

		Scanner sc = new Scanner(System.in);

		// inserting Question from database
		try {
			Connection con = ConnectData.getConnection();
			String sqlQuery = "Select * from QuestionAnswer";

			PreparedStatement ps = con.prepareStatement(sqlQuery);//
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
              
				Questions question = new Questions(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				map.put(question, rs.getString(6));
				
			}
			//ps.close();
		} catch (SQLException e) {
			System.out.println("SQLException occurs while insering questins in Quiz()");
		}

		// iterating Map keys using for each loop

		Set<Questions> set = map.keySet();
		for (Questions a : set) {
            
			System.out.println(a);
			System.out.print("Enter your Option>>");
			String str = sc.next();

			// comparing userinput answer with correct answer which is in value of map
			boolean flag = str.compareToIgnoreCase(map.get(a)) == 0;

			if (str.equalsIgnoreCase("a") || str.equalsIgnoreCase("b") || str.equalsIgnoreCase("c")
					|| str.equalsIgnoreCase("d")) {

				if (flag == true) {
					System.out.println("Correct");
					System.out.println();
					// if answer is correct then result++;
					result++;

				}
				if (flag == false) {
					System.out.println("Wrong answer");
					System.out.println("Correct answer >>" + map.get(a));
					System.out.println();
				}
			}
//if user enter wrong input ie other than a,b,c,d then then it will enter else block ...
// and will exit till it enter the correct input.			
			else {

				while (true) {
					System.out.println("You entered invalid input...");
					System.out.println("Enter the correct option  A,B,C or D...only");
					str = sc.next();
					if (str.compareToIgnoreCase("a") == 0 || str.compareToIgnoreCase("b") == 0
							|| str.compareToIgnoreCase("c") == 0 || str.compareToIgnoreCase("d") == 0) {
						break;

					}

				}

			}
		//	sc.close();
		}

		System.out.println();
		System.out.println("=====================================================================");
		System.out.println();
		
		System.out.println("Your score for exam is >>" + InputData.result);
		
		if ( InputData.result > 8 &&  InputData.result <= 10) {
			System.out.println();
			System.out.println("Your Grade >> Class A");

		} else if ( InputData.result > 6 &&  InputData.result <= 8) {
			System.out.println("Grade >> Class B");
		} else if ( InputData.result == 5) {
			System.out.println("Grade >> Class C");
		} else {
			System.out.println("Grade >> Fail");
		}
	}
}