package com.jpmorgan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class QuestionClassPractice {
	Connection con = null;
	PreparedStatement pstmt = null;
    void getQuestion() throws SQLException{
    		try {
			ConnectionTest connectiontest = new ConnectionTest();
			con = connectiontest.getConnectionDetails();
			//Retrieving Questions from database
			PreparedStatement pstmt = con.prepareStatement("select * from quizquestion ORDER BY RAND()");
			ResultSet rs = pstmt.executeQuery();
			int score=0;
			while(rs.next()) {
				System.out.println("Question Number :"+rs.getInt(1));
				System.out.println("Question is :"+rs.getString(2));
				System.out.println("Option 1 is :"+rs.getString(3));
				System.out.println("Option 2 is :"+rs.getString(4));
				System.out.println("Option 3 is :"+rs.getString(5));
				System.out.println("Option 4 is :"+rs.getString(6));
				//Taking Answer option from user
				    Scanner sc = new Scanner(System.in);
					System.out.println("Choose your answer from the option given above:");
					int option = sc.nextInt();
					System.out.println("Your answer is:"+ option);
				//Calculating score
					    int id=rs.getInt(1);
			    		PreparedStatement pstmt1 = con.prepareStatement("select CorrectAnswer from quizanswer where QuestionNumber=?");
			    		pstmt1.setInt(1,id);
 			  		    ResultSet rs1= pstmt1.executeQuery();
 				    	while(rs1.next()) {
			       		System.out.println("Correct Answer is :"+rs1.getInt(1));
						if(option==rs1.getInt(1)){
						System.out.println("Your Answer is Correct"+"\n");
						score++;
						} 
						else {
						System.out.println("OOPS Your answer is incorrect"+" Correct Answer is:"+rs1.getInt(1)+"\n");
						}
				}
		 	} 
			//Display the score and display the grades according to score
			System.out.println("Your Score is:"+score+"/10");
			if(score>=8 && score<=10) {
				System.out.println("Your Grade is A");
			}
			else if(score>=6 && score<=8) {
				System.out.println("Your Grade is B");
			}
			else if(score==5) {
				System.out.println("Your Grade is C"); 
			}
			else {
				System.out.println("Your Grade is D,Better Try Next time..");
			}
			//INSERTING SCORE IN DATABSE TABLE named scoretable
			System.out.println("Enter your Roll Number to insert your data in database:");
			Scanner sc = new Scanner(System.in);
			int rollno = sc.nextInt();
			PreparedStatement pstmt2 = con.prepareStatement("update scoretable set score=? where RollNo=?");
    		pstmt2.setInt(1,score);
    		pstmt2.setInt(2,rollno);
    		int i = pstmt2.executeUpdate();
    		System.out.println("Record is inserted....."+i);
   	  	   }catch(Exception e) {
    		e.printStackTrace();
    	 }
    		finally {
            con.close();
          }
      }
   }
 



