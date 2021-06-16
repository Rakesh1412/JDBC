package com.te.jdbcDynamic;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			FileInputStream file = new FileInputStream("properties.properties");
			Properties p = new Properties();
			p.load(file);
			cn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pass"));
			String query = "delete from emp where eid=?";
			System.out.println("enter the employee id");
			int id = s.nextInt();
			pst = cn.prepareStatement(query);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("employee is deleted ");
		} catch (Exception e) {
			// TODO: handle exception
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
