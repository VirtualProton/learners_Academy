package com.learnersacademy.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.learnersacademy.sql.Query;

public class StudentList {
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	public void getStudentList() throws ClassNotFoundException, SQLException {
		do{
			Query query = new Query();
			rs= query.fetch("studentlist");
			System.out.println("\nStudent name followed by class name :");
			while(rs.next()) {
				System.out.println(rs.getString(1) +"     "+rs.getString(2));
			}
			System.out.println("1. Add to list");
			System.out.println("2. Delete from list");
			System.out.println("3. back to mein menu");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			switch(sc.nextLine()) {
				case "1":
					addStudent(query);
					break;
				case "2":
					deleteStudent(query);
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
	
	
	private void deleteStudent(Query query) throws SQLException {
		String studentName = null;
		String className = null;
		System.out.println("Enter student name which you want to delete:");
		if(sc.hasNext()) {
			studentName = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		System.out.println("Enter class name of student");
		if(sc.hasNext()) {
			className = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		rs= query.fetch("studentlist");
		while(rs.next()) {
			if(rs.getString(1).equals(studentName) && rs.getString(2).equals(className)) {
				query.deleteStudentData(studentName,className);
			}
		}
		
	}
	
	
	private void addStudent( Query query) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter student name:");
		String studentName = null;
		if(sc.hasNext()) {
			studentName = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		System.out.println("Enter class:");
		String className = null;
		if(sc.hasNext()) {
			className = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		if(check(studentName,className,query)) {
			System.out.println("Student "+studentName+" already present in the" + className+" Class");
		}else {
			query.insertStudentList(studentName,className);
			
		}	
	}
	private boolean check(String input,String input2, Query query) throws SQLException {
		rs= query.fetch("studentlist");
		while(rs.next()) {
			if(rs.getString(1).equals(input) && rs.getString(2).equals(input2)) {
				return true;
			}
		}
		return false;
	}
}
