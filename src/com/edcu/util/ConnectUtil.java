package com.edcu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class ConnectUtil {
	
	private final static String URL = "jdbc:mysql://localhost:3306/studentcore";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "123456";
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnect(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void Close(Connection conn, Statement smt, ResultSet rs) throws SQLException{
		if(conn != null){
			conn.close();
			conn = null;
		}
		if(smt != null){
			smt.close();
			smt = null;
		}
		if(rs != null){
			rs.close();
			rs = null;
		}
	}
}
