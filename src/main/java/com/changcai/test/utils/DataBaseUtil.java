package com.changcai.test.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtil {
	
	public static String sqlDriver = "com.mysql.jdbc.Driver";
	
	public static Connection conn= null;
	public static PreparedStatement pst= null;
	public static String sqlUrl = PropertiesUtil.getSqlURL();
	
	 static   {		
		try {
			Class.forName(sqlDriver);
			conn = DriverManager.getConnection(sqlUrl,"root","root123");		
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	 }
	 
	public static ResultSet findResults(String sqlString) {
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sqlString);
			rs = pst.executeQuery();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void insertData(String sqlString) {
		try{
			pst = conn.prepareStatement(sqlString);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
	
	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
