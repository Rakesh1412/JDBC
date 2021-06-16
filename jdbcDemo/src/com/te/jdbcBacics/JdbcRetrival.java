package com.te.jdbcBacics;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;


public class JdbcRetrival {

	public static void main(String[] args) {
		Employee emp=new Employee();
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		Scanner s=new Scanner(System.in);
		
		try {
			FileInputStream file=new FileInputStream("properties.properties");
			Properties p=new Properties();
			p.load(file);
			cn=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("pass"));
			String query="select * from emp where eid=3;";
			st=cn.createStatement();
			rs=st.executeQuery(query);
			
			while (rs.next()) {
				emp.setEid(rs.getInt("eid"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setSal(rs.getInt("sal"));
				
			}
			
			System.out.println(emp.getEid()+" "+emp.getName()+" "+emp.getEmail()+" "+emp.getSal());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
