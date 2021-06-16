package com.te.jdbcDynamic;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Retrieve {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			FileInputStream file = new FileInputStream("properties.properties");
			Properties p = new Properties();
			p.load(file);
			cn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pass"));
			String query = "select * from emp where eid=?";
			System.out.println("enter the employee id whose details is to be displayed");
			int id = s.nextInt();
			pst = cn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
			}
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
