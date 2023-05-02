package com.ssd.dto;

public class DnameAvgSalDto {

	private String dname;
	private double avgsal;
	
	
	
	public DnameAvgSalDto() {
		super();
	}


	public DnameAvgSalDto(String dname, double avgsal) {
		super();
		this.dname = dname;
		this.avgsal = avgsal;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public double getAvgsal() {
		return avgsal;
	}


	public void setAvgsal(double avgsal) {
		this.avgsal = avgsal;
	}


	@Override
	public String toString() {
		return "DnameAvgSalDto [dname=" + dname + ", avgsal=" + avgsal + "]";
	}
	
	
	
}
