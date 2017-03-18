package com.jiangsu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.util.Properties;


public class jdbc {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
		conn = getConnection();
		//3.�õ�ִ��SQL���Ķ���statement
		stmt = (Statement) conn.createStatement();
		
		//4.ִ��SQL��䣬�����ؽ��
		rs = (ResultSet) stmt.executeQuery("SELECT id,name,password,email,birthday FROM users");
		List<user> users = new ArrayList<user>();
		//int i = stmt.executeUpdate("INSERT INTO users VALUES(5,'tom','123','tom@163.com','2016-12-25')");
//		if(i>0){
//			System.out.println("success");
//		}else{
//			System.out.println("�޸���"+i+"��");
//		}
		//5.������
		while(rs.next()){
			user u = new user();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setBirthday(rs.getString("birthday"));
			users.add(u);
		}	
		

		for(user u2 : users){
			System.out.println(u2);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(conn, stmt, rs);
		}
		
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs) {
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

	private static Connection getConnection() throws SQLException, ClassNotFoundException {
		//1.ע������
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		//2.��ȡ����connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","123");
		//��ʽ��
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=123");
		//��ʽ��
		//Properties info = new Properties();
		//info.setProperty("user", "root");
		//info.setProperty("password", "123");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06",info);
		return conn;
	}

}
