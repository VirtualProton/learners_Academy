package com.learnersacademy.main;
import java.sql.SQLException;

import com.learnersacademy.core.AdLogin;


public class LearnersAcademy {
 public static void main(String [] args) throws ClassNotFoundException, SQLException{
	 System.out.println("Welcome To Learner's Academy");
	 		AdLogin ad = new AdLogin();
	 		ad.login();
 }
}
