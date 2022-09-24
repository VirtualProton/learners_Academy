package com.learnersacademy.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.learnersacademy.sql.Query;

public class ClassList {
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	public void getClassList() throws ClassNotFoundException, SQLException {
		do{
			Query query = new Query();
			rs= query.fetch("classlist");
			System.out.println("\nClass List:");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			System.out.println("1. Add to list");
			System.out.println("2. Delete from list");
			System.out.println("3. back to mein menu");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			switch(sc.nextLine()) {
				case "1":
					addClass(query);
					break;
				case "2":
					deleteClass(query);
					break;
				case "3":
					Menu menu = new Menu();
					break;
				case "4":
					  System.exit(0);
					break;
				default:
					System.out.println("Invalid Input");
			}
			
		}while(true); 
	}
	private void deleteClass(Query query) throws SQLException {
		String className = null;
		
		System.out.println("Enter class name which you want to delete:");
		if(sc.hasNext()) {
			className = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		rs= query.fetch("classlist");
		while(rs.next()) {
			if(rs.getString(1).equals(className)) {
				query.deleteClassData(className);
			}
		}
		
	}
	private void addClass( Query query) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter class name:");
		String input = null ;
		if(sc.hasNext()) {
			input = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		if(check(input,query)) {
			System.out.println("Class "+input+" already present in the list");
		}else {
			query.insertClassList(input);
			
		}
		
	}
	private boolean check(String input, Query query) throws SQLException {
		rs= query.fetch("classlist");
		while(rs.next()) {
			if(rs.getString(1).equals(input)) {
				return true;
			}
		}
		return false;
	}
}
