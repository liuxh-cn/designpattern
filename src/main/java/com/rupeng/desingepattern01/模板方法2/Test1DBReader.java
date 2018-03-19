package com.rupeng.desingepattern01.模板方法2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test1DBReader extends DBReader{

	@Override
	protected Connection createConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT","root","root");
		return conn;
	}	

	@Override
	protected void processResultSet(ResultSet rs) throws SQLException {
		//打印每行数据第一列
		while(rs.next()){
			String v = rs.getString(1);
			System.out.println(v);
		}
	}

	public static void main(String[] args) {
		new Test1DBReader().executeQuery("select * from people");
	}

}
