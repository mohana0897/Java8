package com.ssd.empProject;

public class Employee{

	private String name;
	private Double sal;
	private String job;
	private Long id;
	private Long supId;
	
	
	

	@Override
	public String toString() {
		return "Employee [name=" + name + ", sal=" + sal + ", job=" + job + ", id=" + id + ", supId=" + supId + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSupId() {
		return supId;
	}

	public void setSupId(Long supId) {
		this.supId = supId;
	}

	public Employee(String name, Double sal, String job, Long id, Long supId) {
		super();
		this.name = name;
		this.sal = sal;
		this.job = job;
		this.id = id;
		this.supId = supId;
	}

	public Employee() {
		super();
	}


	

}
