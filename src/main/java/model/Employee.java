package model;

public class Employee {

	private int id;
	private String name;
	private String account;
	private String dept;
	private Integer age;
	private Double salary;

	public Employee(int id, String name, String account, String dept, Integer age, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.age = age;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", account=" + account + ", dept=" + dept + ", age=" + age
				+ ", salary=" + salary + "]";
	}

}