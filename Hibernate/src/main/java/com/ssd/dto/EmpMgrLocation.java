package com.ssd.dto;

public class EmpMgrLocation {

	//e.ename,d.loc, m.ename,dm.loc
	
	private String ename;
	private String empLoc;
	private String mName;
	private String mgrLoc;
	
	
	
	public EmpMgrLocation() {
		super();
	}



	@Override
	public String toString() {
		return "EmpMgrLocation [ename=" + ename + ", empLoc=" + empLoc + ", mName=" + mName + ", mgrLoc=" + mgrLoc
				+ "]";
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public String getEmpLoc() {
		return empLoc;
	}



	public void setEmpLoc(String empLoc) {
		this.empLoc = empLoc;
	}



	public String getmName() {
		return mName;
	}



	public void setmName(String mName) {
		this.mName = mName;
	}



	public String getMgrLoc() {
		return mgrLoc;
	}



	public void setMgrLoc(String mgrLoc) {
		this.mgrLoc = mgrLoc;
	}



	public EmpMgrLocation(String ename, String empLoc, String mName, String mgrLoc) {
		super();
		this.ename = ename;
		this.empLoc = empLoc;
		this.mName = mName;
		this.mgrLoc = mgrLoc;
	}
	
	
	
}
