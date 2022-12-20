package com.jpmorgan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnswerClass{
	Connection con = null;
	PreparedStatement pstmt = null;
	void getCorrectAnswer(){
		try {
			ConnectionTest connectiontest = new ConnectionTest();
			con = connectiontest.getConnectionDetails();
			pstmt = con.prepareStatement("select * from quizanswer");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Here is the Answer Key:"+"\n");
			while(rs.next()) {
				System.out.println("Question Number:"+rs.getInt(2));
				System.out.println("Correct Answer is :"+rs.getString(3)+"\n"); 
				ArrayList<String> al = new ArrayList<String>();
				al.add(rs.getString(3));
				}
			con.close();
			pstmt.close();
			rs.close();
			}catch(Exception e) {
			System.out.println(e);
		}
	}
}
