package com.jpmorgan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class ResultClass {
	Connection con = null;
	PreparedStatement pstmt = null;
	void displayResult() {
			try {
			ConnectionTest connectiontest = new ConnectionTest();
			con=connectiontest.getConnectionDetails();
			//Retrieving scoretable from databse
			PreparedStatement pstmt = con.prepareStatement("select * from scoretable ORDER BY score DESC ");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Result of students are:");
			while(rs.next()) {
			System.out.println("Roll Number :"+rs.getInt(1));
			System.out.println("Name is :"+rs.getString(2));
			System.out.println("Score is :"+rs.getInt(3));
		} 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void resultFromRollNo() throws SQLException {
			try {
			System.out.println("Enter your Roll Number to check your score:");
			Scanner sc = new Scanner(System.in);
			int rollno = sc.nextInt();
			ConnectionTest connectiontest = new ConnectionTest();
			con = connectiontest.getConnectionDetails();
			PreparedStatement pstmt = con.prepareStatement("select score from scoretable where RollNo=?");
			pstmt.setInt(1,rollno);
	  	    ResultSet rs1= pstmt.executeQuery();
	  	    while(rs1.next()) {
	        System.out.println("Your Score is :"+rs1.getInt(1));
	  	  }	
		}catch(Exception e) {
		 e.printStackTrace();
		}
		finally {
			 con.close();
		}
	}
}

