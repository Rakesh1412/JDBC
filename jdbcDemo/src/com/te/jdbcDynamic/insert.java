package com.te.jdbcDynamic;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class insert {

	public static void main(String[] args) {
		Connection cn = null;
		PreparedStatement pst = null;
		Scanner s = new Scanner(System.in);
		try {
			FileInputStream file = new FileInputStream("properties.properties");
			Properties p = new Properties();
			p.load(file);
			cn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pass"));
			String query = "insert into emp values(?,?,?,?)";
			System.out.println("enter the employee id");
			int id = s.nextInt();
			System.out.println("enter the employee name");
			String name = s.next();
			System.out.println("enter the employee email");
			String email = s.next();
			System.out.println("enter the employee salary");
			int sal = s.nextInt();
			pst = cn.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.setInt(4, sal);
			pst.executeUpdate();
			System.out.println("data Sucessfully added");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (cn != null) {
					cn.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (s != null) {
					s.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}
}
