package com.te.dao;

import com.te.bean.EmployeeData;

public interface EmployeeDAO {
	public EmployeeData getSingleRecord(int id);
	public void getAlRecords();
	public void insertRecord(EmployeeData a);
	
}
