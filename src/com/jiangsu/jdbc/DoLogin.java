package com.jiangsu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DoLogin {

	/**
	 * 根據用戶名和密碼查詢用戶
	 * @param name
	 * @param password
	 * @return
	 */
	public static user findUser(String name,String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		user u = null;
		try{
			conn = DBUtils.getConnection();
			String sql = "select * from users where name=? and password=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()){
			    u = new user();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setBirthday(rs.getString("birthday"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, stmt, conn);
		}
		return u;
	}

}
