package com.learnersacademy.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.learnersacademy.db.DatabaseConnection;

public class AdLogin {
	public void login() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 String userid = null;
		 String pass = null;
		do {
		Scanner sc = new Scanner(System.in);
		System.out.print("User Id: ");
		if(sc.hasNext()) {
			userid = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		System.out.print("Password: ");
	
		if(sc.hasNext()) {
			pass = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		if(verify(userid,pass)) {
				Menu menu = new Menu();
			}else {
				System.err.println("Incorrect User ID or Password!");
				System.out.println("Try Again");
			}
		}while(true);
		
	}
	private boolean verify(String userid, String pass) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = DatabaseConnection.mysqlConnection();;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("select * from administrator");
			rs = ps.executeQuery();
			while(rs.next()) {
				if(userid.equals(rs.getString(1)) && pass.equals(rs.getString(2)) ) {
					return true;
				}else {
					System.out.println("line 45");
				}
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DatabaseConnection.cleanUp(connection, ps);
			}
		return false;
	}
}
