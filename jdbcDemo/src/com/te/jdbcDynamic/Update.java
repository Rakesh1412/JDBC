package com.te.jdbcDynamic;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PreparedStatement pst = null;
		Connection cn = null;
		try {
			FileInputStream file = new FileInputStream("properties.properties");
			Properties p = new Properties();
			p.load(file);

			cn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pass"));
			String query = "update emp set sal=? where name=?";
			System.out.println("enter the employee name");
			String name = s.next();
			System.out.println("enter the employee new salary");
			int sal = s.nextInt();
			pst = cn.prepareStatement(query);
			pst.setInt(1, sal);
			pst.setString(2, name);
			pst.executeUpdate();
			System.out.println("salary updated");
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
