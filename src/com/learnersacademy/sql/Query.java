package com.learnersacademy.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learnersacademy.db.DatabaseConnection;

public class Query {
	Connection connection = null;
	PreparedStatement ps = null;
	public Query() throws ClassNotFoundException, SQLException {
		super();
		this.connection = DatabaseConnection.mysqlConnection();
	}
	
	
	//-------------------Insert Queries------------------------
	
	// inserted class 
	public void insertClassList(String input1) throws SQLException {
		int record = 0;
		try {
			if(input1.equals(null)) {
				System.out.println("Field cannot be empty");
			}else {
		ps = connection.prepareStatement("insert into classlist values(?)");
		ps.setString(1, input1);
		record = ps.executeUpdate();
		if(record == 1){
				System.out.println("Data inserted successfully");
			}else {
				System.out.println("Error occured while inserting");
			}
		 }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// inserted subject
	public void insertSubjectList(String subject) throws SQLException {
		int record = 0;
		try {
			if(subject.equals(null)) {
				System.out.println("Field cannot be empty");
			}else {
		ps = connection.prepareStatement("insert into subjectlist values(?)");
		ps.setString(1, subject);
		record = ps.executeUpdate();
		if(record == 1){
				System.out.println("Data inserted successfully");
			}else {
				System.out.println("Error occured while inserting");
			}
		 }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//teacher data inserted
	public void insertTeacherList(String teachername) throws SQLException {
		
		int record = 0;
		try {
		ps = connection.prepareStatement("INSERT INTO teacherlist VALUES(null,?)");
		ps.setString(1, teachername);
		record = ps.executeUpdate();
		if(record == 1){
				System.out.println("Data inserted successfully");
			}else {
				System.out.println("Error occured while inserting");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//student data inserted
	public void insertStudentList(String studentname, String classname) throws SQLException {
		
		int record = 0;
		try {
		ps = connection.prepareStatement("INSERT INTO studentlist VALUES(?,?)");
		ps.setString(1, studentname);
		ps.setString(2, classname);
		record = ps.executeUpdate();
		if(record == 1){
				System.out.println("Data inserted successfully");
			}else {
				System.out.println("Error occured while inserting");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//subject teacher assigned table inserted.
		public void insertAssignedList(String className, int teacherID,String Subject) throws SQLException {
			// insert  class details
			int record = 0;
			try {
			ps = connection.prepareStatement("INSERT INTO assignedlist VALUES(?,?,?)");
			ps.setString(1, className);
			ps.setInt(2, teacherID);
			ps.setString(3, Subject);
			record = ps.executeUpdate();
			if(record == 1){
					System.out.println("Data inserted successfully");
				}else {
					System.out.println("Error occured while inserting");
				}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		
		
		
 //--------------------------- data fetch Queries ------------------------------
		
		public ResultSet fetch(String tablename) throws SQLException {
			try {
				ps = connection.prepareStatement("select * from "+tablename);
				return ps.executeQuery();
				}catch(Exception e) {
					e.printStackTrace();
				}
			return null;
		}
		
		public ResultSet sub_teacherlist(String className) {
			try {
				ps = connection.prepareStatement("select teachername, subjectname from assignedlist,teacherlist where classname= ? and teacherlist.teacherid = assignedlist.teacherid");
				ps.setString(1, className);
				return ps.executeQuery();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;			
		}
		
		public ResultSet student_list(String className) {
			try {
				ps = connection.prepareStatement("select studentname from studentlist where classname = ?");
				ps.setString(1, className);
				return ps.executeQuery();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;			
		}


	
		
		//--------------------------- data delete Queries ------------------------------
		public void deleteAssigData(String className, String subjectName) {
			int record = 0;
			try {
			ps = connection.prepareStatement("DELETE FROM assignedlist WHERE classname = ? and subjectname = ?");
			ps.setString(1, className);
			ps.setString(2, subjectName);
			record = ps.executeUpdate();
			if(record == 1){
					System.out.println("Data deleted successfully");
				}else {
					System.out.println("Error occured while inserting");
				}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}


		public void deleteClassData(String className) {
			// TODO Auto-generated method stub
			int record = 0;
			try {
			ps = connection.prepareStatement("DELETE FROM classlist WHERE classname = ?");
			ps.setString(1, className);
			record = ps.executeUpdate();
			if(record == 1){
					System.out.println("Data deleted successfully");
				}else {
					System.out.println("Error occured while deleting");
				}
			
			}catch(Exception e) {
				System.out.println("Cannot delete becasue student, subjects and techers are asssigned to this class");
			}
			
		}


		public void deleteStudentData(String studentName, String className) {
			// TODO Auto-generated method stub
			int record = 0;
			try {
			ps = connection.prepareStatement("DELETE FROM studentlist WHERE studentname = ? and classname = ?");
			ps.setString(1, studentName);
			ps.setString(2, className);
			record = ps.executeUpdate();
			if(record == 1){
					System.out.println("Data deleted successfully");
				}else {
					System.out.println("Error occured while deleting");
				}
			
			}catch(Exception e) {
				e.printStackTrace();
			}

		}


		public void deleteSubjectData(String subjectName) {
			// TODO Auto-generated method stub
						int record = 0;
						try {
						ps = connection.prepareStatement("DELETE FROM subjectlist WHERE subjectname = ?");
						ps.setString(1, subjectName);
						record = ps.executeUpdate();
						if(record == 1){
								System.out.println("Data deleted successfully");
							}else {
								System.out.println("Error occured while deleting");
							}
						
						}catch(Exception e) {
							System.out.println("Cannot delete becasue student, class and techers are asssigned to this subject");
						}
		}


		public void deleteTeacherData(String teacherID) {
			// TODO Auto-generated method stub
			int record = 0;
			try {
			ps = connection.prepareStatement("DELETE FROM teacherlist WHERE teacherid = ?");
			ps.setInt(1, Integer.parseInt(teacherID));
			record = ps.executeUpdate();
			if(record == 1){
					System.out.println("Data deleted successfully");
				}else {
					System.out.println("Error occured while deleting");
				}
			
			}catch(Exception e) {
				System.out.println("Cannot delete becasue student, class and subject are asssigned to this teacher");
			}
		}

		
}
