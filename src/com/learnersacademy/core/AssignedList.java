package com.learnersacademy.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.learnersacademy.sql.Query;

public class AssignedList {
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	public void getAssignList() throws ClassNotFoundException, SQLException {

		do{
			Query query = new Query();
			rs= query.fetch("assignedlist");
			System.out.println("\nTeacehr assigned to subject of class :\n");
			while(rs.next()) {
				System.out.println(rs.getString(1) +"     "+rs.getString(2)+ "     "+rs.getString(3));
			}
			System.out.println("1. Add to list");
			System.out.println("2. Delete from list");
			System.out.println("3. back to mein menu");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			switch(sc.nextLine()) {
				case "1":
					addAssigned(query);
					break;
				case "2":
					deleteAssigned(query);
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
	private void deleteAssigned(Query query) throws SQLException {
		String className = null;
		String subjectName = null;
		System.out.println("Enter class name which you want to delete:");
		if(sc.hasNext()) {
			className = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		System.out.println("Enter subject name which you want to delete:");
		if(sc.hasNext()) {
			subjectName = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		rs= query.fetch("assignedlist");
		while(rs.next()) {
			if(rs.getString(1).equals(className) && rs.getString(3).equals(subjectName)) {
				query.deleteAssigData(className,subjectName);
			}
		}
		
	}
	private void addAssigned(Query query) throws NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("Enter Class:");
				String className = null;
				if(sc.hasNext()) {
					className = sc.nextLine();
					}else {
						System.out.println("Thank you..!");
						System.exit(0);
					}
				if(isclass(className,query)) {
					System.out.println("Enter Teacehr ID:");
					String teacherID = null ;
					if(sc.hasNext()) {
						teacherID = sc.nextLine();
						}else {
							System.out.println("Thank you..!");
							System.exit(0);
						}
					if(isteacher(teacherID,query)) {
						System.out.println("Enter subject:");
						String subjectName = null ;
						if(sc.hasNext()) {
							subjectName = sc.nextLine();
							}else {
								System.out.println("Thank you..!");
								System.exit(0);
							}
						if(issubject(subjectName,query)) {
							if(check(className,teacherID,subjectName,query)) {
								System.out.println("Teacher ID "+teacherID+" already assigned to" + subjectName+"  of Class "+className);
							}else {
								query.insertAssignedList(className,Integer.parseInt(teacherID),subjectName);
							}	
						}else {
							System.out.println("Subject "+subjectName+" is not present is subject list. Kindly register "+subjectName+" in subject list.");
						}
					}else {
						System.out.println("There is no teacher with Id "+teacherID+" in teacher list. Kindly check teacher list for correct teacher Id.");
					}
				}else {
					System.out.println("Class "+className+" is not present is classlist. Kindly register "+className+" in class list.");
				}
				
	}
	private boolean issubject(String subjectName, Query query) throws SQLException {
		// TODO Auto-generated method stub
		rs= query.fetch("subjectlist");
		while(rs.next()) {
			if(rs.getString(1).equals(subjectName)) {
				return true;
			}
		}
		return false;
	}
	private boolean isteacher(String teacherID, Query query) throws SQLException {
		// TODO Auto-generated method stub
		rs= query.fetch("teacherlist");
		while(rs.next()) {
			if(rs.getString(1).equals(teacherID)) {
				return true;
			}
		}
		return false;
	}
	private boolean isclass(String className, Query query) throws SQLException {
		// TODO Auto-generated method stub
		rs= query.fetch("classlist");
		while(rs.next()) {
			if(rs.getString(1).equals(className)) {
				return true;
			}
		}
		return false;
	}
	private boolean check(String className, String teacherID, String subjectName, Query query) throws SQLException {
		// TODO Auto-generated method stub
		rs= query.fetch("assignedlist");
		while(rs.next()) {
			if(rs.getString(1).equals(className) && rs.getString(2).equals(teacherID) && rs.getString(3).equals(subjectName)) {
				return true;
			}
		}
		return false;
	}

}
