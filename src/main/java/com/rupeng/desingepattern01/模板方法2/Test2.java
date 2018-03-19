package com.rupeng.desingepattern01.模板方法2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test2 {
	
	public static void main(String[] args) {
		new DBReader() {

			@Override
			protected void processResultSet(ResultSet rs) throws SQLException {
				while(rs.next()){
					System.out.println("anonymous class : " + rs.getString(2));
				}
			}

			@Override
			protected Connection createConnection() throws SQLException {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mysql_demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT","root","root");
				return conn;
			}
		}.executeQuery("select * from people");
	}
}
