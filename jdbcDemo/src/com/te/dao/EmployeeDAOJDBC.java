package com.te.dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import com.te.bean.EmployeeData;

public class EmployeeDAOJDBC implements EmployeeDAO {

	@Override
	public EmployeeData getSingleRecord(int id) {
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		EmployeeData empData = new EmployeeData();
		try {
			FileInputStream file = new FileInputStream("properties.properties");
			Properties p = new Properties();
			p.load(file);
			cn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("pass"));
			String query = "select * from emp where eid=?";
			pst = cn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				empData.setId(rs.getInt(1));
				empData.setName(rs.getString(2));
				empData.setEmail(rs.getString(3));
				empData.setSal(rs.getInt(4));
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return empData;
	}

	@Override
	public void getAlRecords() {
		System.out.println("all records");

	}

	@Override
	public void insertRecord(EmployeeData a) {
		System.out.println("inserting data");

	}

}
