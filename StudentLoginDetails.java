package com.jpmorgan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class StudentLoginDetails {
	Connection con = null;
	PreparedStatement pstmt = null;
void getStudentLoginDetails() throws SQLException {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of students interested to take quiz:");
	int n = sc.nextInt();
	for(int i=1;i<=n;i++) {
		System.out.println("Enter your Roll Number to take this Quiz:");
		int rollno = sc.nextInt();
		System.out.println("Enter your Name:");
		String studentname = sc.next();
		//INSERTING ROLLNO AND NAME IN DATABASE TABLE named scoretable
		try{
		ConnectionTest connectiontest = new ConnectionTest();
		con = connectiontest.getConnectionDetails();
		pstmt = con.prepareStatement("insert into scoretable(RollNo,name)values(?,?)");
		pstmt.setInt(1,rollno);
		pstmt.setString(2,studentname);
		int j = pstmt.executeUpdate();
		System.out.println("Record is inserted....."+j);
		}catch(Exception e) {
			e.printStackTrace();
		}
		con.close();
		pstmt.close();
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		hm.put(rollno,studentname);
		System.out.println(hm+"\n");
		
		//Creating object of QuestionClass to call its method getQuestion() so that multiple students can take this quiz
		System.out.println("Lets Start Your Quiz!"+"\n");
		QuestionClassPractice questionclass = new QuestionClassPractice();
		questionclass.getQuestion();
	  }
   }
}


