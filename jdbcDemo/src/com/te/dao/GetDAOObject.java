package com.te.dao;

public class GetDAOObject {
	static String type="jdbc";
	public static EmployeeDAO getObject() {
		if(type.equalsIgnoreCase("jdbc")) {
			return new EmployeeDAOJDBC();
		}else if(type.equalsIgnoreCase("hibernate")) {
			return new EmployeeDAOHibernate();
		}else if(type.equalsIgnoreCase("jdbc")) {
			return new EmployeeDAOJDBC();
		}else {
			return null;
		}
	}
}
