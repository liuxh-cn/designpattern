package com.rupeng.desingepattern01.责任链模式3;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test1 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");//触发com.mysql.jdbc.Driver静态代码块的执行
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/mysql_demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT",
				"root", "root");
		System.out.println(conn.getClass());
	}
}
