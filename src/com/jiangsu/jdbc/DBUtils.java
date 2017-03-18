package com.jiangsu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Statement;

public class DBUtils {

	private static String url;
	private static String user;
	private static String password;
	private static String driverClass;
	static{
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
	    url = rb.getString("url");
		user = rb.getString("user");
		password = rb.getString("password");
		driverClass = rb.getString("driverClass");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	
	public static void closeAll(ResultSet rs,PreparedStatement stmt, Connection conn){
		if(rs!=null){
			try{
				rs.close();
			}catch (Exception e){
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try{
				stmt.close();
			}catch (Exception e){
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try{
				conn.close();
			}catch (Exception e){
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
