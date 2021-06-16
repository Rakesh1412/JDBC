package com.te.jdbcBacics;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class JdbcInsertOP {

	public static void main(String[] args) {
		Connection cn=null;
		Statement st=null;
		Scanner s=new Scanner(System.in);
		try {
			FileInputStream file=new FileInputStream("properties.properties");
			Properties p=new Properties();
			p.load(file);
			cn=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("pass"));
			String query="insert into emp values(5,'adi','adi@gmail.com',95000)";
			st=cn.createStatement();
			st.executeUpdate(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
