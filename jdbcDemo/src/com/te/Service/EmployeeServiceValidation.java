package com.te.Service;

import com.te.bean.EmployeeData;
import com.te.dao.GetDAOObject;

public class EmployeeServiceValidation implements EmployeeService {

	@Override
	public EmployeeData getSingleRecord(int id) {
		
		if(id<1) {
			return null;
		}
		return GetDAOObject.getObject().getSingleRecord(id);
	}

	@Override
	public void getAlRecords() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertRecord(EmployeeData a) {
		// TODO Auto-generated method stub

	}

}
