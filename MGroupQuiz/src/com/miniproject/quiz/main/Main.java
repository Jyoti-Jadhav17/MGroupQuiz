package com.miniproject.quiz.main;

import com.miniproject.quiz.java.InputData;
import com.miniproject.quiz.java.LoginDetail;
import com.miniproject.quiz.mysql.jdbc.RetrivalData;

public class Main {
public static void main(String[] args) {
	LoginDetail.studentInfo();
	InputData.quiz();
	LoginDetail.addStudentInfo();
	RetrivalData.showResult();
	
	
}
}
