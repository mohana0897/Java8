package com.ssd.Employee;

public class Employee {


	private String name;
	private String dept;
	private String address;
	private int sal;
	
	
	public Employee() {
		super();
	}


	public Employee(String name, String dept, String address, int sal) {
		super();
		this.name = name;
		this.dept = dept;
		this.address = address;
		this.sal = sal;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getSal() {
		return sal;
	}


	public void setSal(int sal) {
		this.sal = sal;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", address=" + address + ", sal=" + sal + "]";
	}


	

	
	
	

	
	
	
}
