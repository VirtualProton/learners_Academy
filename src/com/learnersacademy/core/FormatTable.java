package com.learnersacademy.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;

public class FormatTable {

	public void printTable(ResultSet rs1, ResultSet rs2) throws SQLException {
		// TODO Auto-generated method stub
		Formatter table1 = new Formatter(); 
		Formatter table2 = new Formatter();
		
		table1.format("%15s\n", "Student Name");
		while(rs1.next()) {
			table1.format("%14s\n", rs1.getString(1)); 
			//System.out.println(rs1.getString(1));
		}
		
		table2.format("%15s %15s\n", "Teacher Name","Subject Name");
		while(rs2.next()) {
			table2.format("%14s %14s\n", rs2.getString(1), rs2.getString(2)); 
			//System.out.println(rs2.getString(1)+"  "+rs2.getString(2));
		}
		
		System.out.print(table1);
		System.out.print("\n");
		System.out.print(table2);
		System.out.print("\n");
	}

}
