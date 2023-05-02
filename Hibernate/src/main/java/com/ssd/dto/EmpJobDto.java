package com.ssd.dto;

public class EmpJobDto {
	
	private String ename;
	private String job;
	
	
	
	public EmpJobDto() {
		super();
	}
	public EmpJobDto(String ename, String job) {
		super();
		this.ename = ename;
		this.job = job;
	}
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
	@Override
	public String toString() {
		return "EmpJobDto [ename=" + ename + ", job=" + job + "]";
	}
	
	

}
