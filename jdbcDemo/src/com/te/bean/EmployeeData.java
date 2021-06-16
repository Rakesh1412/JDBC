package com.te.bean;

public class EmployeeData {
	int id;
	String name;
	String email;
	int sal;

	public EmployeeData() {
		super();
	}
	
	public EmployeeData(int id, String name, String email, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.sal = sal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

}
