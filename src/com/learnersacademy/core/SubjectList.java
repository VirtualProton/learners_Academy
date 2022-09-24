package com.learnersacademy.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.learnersacademy.sql.Query;

public class SubjectList {
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	public void getSubjectList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		do{
			Query query = new Query();
			rs= query.fetch("subjectlist");
			System.out.println("\nSubjects:");
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
					addSubject(query);
					break;
				case "2":
					deleteSubject(query);
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
	private void deleteSubject(Query query) throws SQLException {
		// TODO Auto-generated method stub
		String subjectName = null;
		
		System.out.println("Enter subject name which you want to delete:");
		if(sc.hasNext()) {
			subjectName = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		rs= query.fetch("subjectlist");
		while(rs.next()) {
			if(rs.getString(1).equals(subjectName)) {
				query.deleteSubjectData(subjectName);
			}
		}
		
	}
	
	private void addSubject(Query query) throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String subject = null;
				System.out.println("Enter subject name add:");
				if(sc.hasNext()) {
					subject = sc.nextLine();
					}else {
						System.out.println("Thank you..!");
						System.exit(0);
					}
				if(check(subject,query)) {
					System.out.println("Subject "+subject+" already present in the list");
				}else {
					query.insertSubjectList(subject);
					
				}
	}
	private boolean check(String input, Query query) throws SQLException {
		// TODO Auto-generated method stub
		rs= query.fetch("subjectlist");
		while(rs.next()) {
			if(rs.getString(1).equals(input)) {
				return true;
			}
		}
		return false;
	}

}
