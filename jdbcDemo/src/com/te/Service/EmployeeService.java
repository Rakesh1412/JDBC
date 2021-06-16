package com.te.Service;

import com.te.bean.EmployeeData;

public interface EmployeeService {
	public EmployeeData getSingleRecord(int id);
	public void getAlRecords();
	public void insertRecord(EmployeeData a);
}
