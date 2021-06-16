package com.te.Service;

import com.te.bean.EmployeeData;

public class MainService {

	public static void main(String[] args) {
		EmployeeServiceValidation esv=new EmployeeServiceValidation();
		EmployeeData emp=esv.getSingleRecord(1);
		
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getEmail());
		System.out.println(emp.getSal());

	}

}
