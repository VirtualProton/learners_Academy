package com.learnersacademy.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.learnersacademy.sql.Query;

public class ClassReport {
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	public void showReport() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.print("Entern class name:");
		String className = null;
		if(sc.hasNext()) {
			className = sc.nextLine();
			}else {
				System.out.println("Thank you..!");
				System.exit(0);
			}
		Query query = new Query();
		rs= query.fetch("classlist");
		while(rs.next()) {
			if(rs.getString(1).equals(className)) {
				ResultSet rs1= query.student_list(className);
				ResultSet rs2 = query.sub_teacherlist(className);
				FormatTable ft = new FormatTable();
				ft.printTable(rs1,rs2);
			}
		}
	}

}
