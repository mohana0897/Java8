package com.ssd.practiceHQLqueries;

public class EmpNameDeptName {

	private String ename;
	private String dname;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public EmpNameDeptName(String ename, String dname) {
		super();
		this.ename = ename;
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "EmpNameDeptName [ename=" + ename + ", dname=" + dname + "]";
	}
	public EmpNameDeptName() {
		super();
	}
	
	
	
}
