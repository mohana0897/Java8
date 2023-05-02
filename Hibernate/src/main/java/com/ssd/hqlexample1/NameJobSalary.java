package com.ssd.hqlexample1;

public class NameJobSalary {
	
	
	private String ename;
	private String job;
	private Double sal;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public NameJobSalary(String ename, String job, Double sal) {
		super();
		this.ename = ename;
		this.job = job;
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "NameJobSalary [ename=" + ename + ", job=" + job + ", sal=" + sal + "]";
	}
	public NameJobSalary() {
		super();
	}
	
	
	
}
