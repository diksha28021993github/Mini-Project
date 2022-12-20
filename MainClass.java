package com.jpmorgan;

import java.sql.SQLException;

public class MainClass {
	public static void main(String[]args) throws SQLException {
		//Creating object of StudentLoginDetails to take student login details,display question and take user answer
		StudentLoginDetails studentlogindetails = new StudentLoginDetails();
		studentlogindetails.getStudentLoginDetails();
		
		//Creating object of AnswerClass to display correct Answer(ANSWER KEY)
		AnswerClass answerclass = new AnswerClass();
		answerclass.getCorrectAnswer();
		
		//Creating object of ResultClass to call its method displayResult() and resultFromRollNo()
		ResultClass resultclass = new ResultClass();
		resultclass.displayResult();
		resultclass.resultFromRollNo();
	}
}



