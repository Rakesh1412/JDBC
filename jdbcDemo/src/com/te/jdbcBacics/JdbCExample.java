package com.te.jdbcBacics;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class JdbCExample {

	public static void main(String[] args) {
		java.sql.Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_info","root","root");
			st=cn.createStatement();
			String query="select * from emp;";
			rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
