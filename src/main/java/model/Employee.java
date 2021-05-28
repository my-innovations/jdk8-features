package model;

public class Employee implements Comparable<Employee> {

	private Integer age;
	private String name;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Employee e) {

		if (this.getAge() < (e.getAge()))
			return -1;
		else if (this.getAge() > (e.getAge()))
			return 1;
		return 0;
	}

}
