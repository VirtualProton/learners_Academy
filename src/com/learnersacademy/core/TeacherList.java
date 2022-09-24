package com.learnersacademy.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.learnersacademy.sql.Query;

public class TeacherList {
	private ResultSet rs;
	private Scanner sc = new Scanner(System.in);
	public void getTeacherList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		do{
			Query query = new Query();
			rs= query.fetch("teacherlist");
			System.out.println("\nTeacher Name: ");
			while(rs.next()) {
				System.out.println(rs.getString(1) +". "+rs.getString(2));
			}
			System.out.println("\n\n");
			System.out.println("1. Add to list");
			System.out.println("2. Delete from list");
			System.out.println("3. back to mein menu");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			switch(sc.nextLine()) {
				case "1":
					addTeacher(query);
					break;
				case "2":
					deleteTeacher(query);
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

	private void deleteTeacher(Query query) throws SQLException {
		// TODO Auto-generated method stub
		String teacherID = null;
		
		System.out.println("Enter Teacher ID which you want to delete:");
		if(sc.hasNext()) {
			teacherID = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		rs= query.fetch("teacherlist");
		while(rs.next()) {
			if(rs.getString(1).equals(teacherID)) {
				query.deleteTeacherData(teacherID);
			}
		}
	}

	private void addTeacher(Query query) throws SQLException {
		// TODO Auto-generated method stub
				System.out.println("Enter Teacher name:");
				String teacherName = null;
				if(sc.hasNext()) {
					teacherName = sc.nextLine();
					}else {
						System.out.println("Thank you..!");
						System.exit(0);
					}
				query.insertTeacherList(teacherName);
	}

}
