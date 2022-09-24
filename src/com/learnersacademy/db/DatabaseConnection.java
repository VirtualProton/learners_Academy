package com.learnersacademy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
	 
	public static Connection mysqlConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learners_academy","root","root");
		return con;
	}
	
	public static void cleanUp(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		con.close();
		ps.close();
		rs.close();
	}

	public static void cleanUp(Connection con, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		con.close();
		ps.close();
	}
}
