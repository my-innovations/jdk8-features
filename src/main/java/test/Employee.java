package test;

import java.time.LocalDate;

class Emp {

	private String name;
	private Integer sal;
	private String deptName;
	private LocalDate dob;

	public Emp(String name, Integer sal, String deptName, LocalDate dob) {
		super();
		this.name = name;
		this.sal = sal;
		this.deptName = deptName;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSal() {
		return sal;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", sal=" + sal + ", deptName=" + deptName + ", dob=" + dob + "]";
	}
	
	

}
