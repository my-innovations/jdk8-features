package model;

import java.util.List;

public class Person {

	public String firstName;
	public String lastName;
	public Double sal;
	public String gender;
	public Integer height;
	public List<String> hobbies;

	public Person() {
	}

	public Person(String firstName, String lastName, Double sal, String gender, Integer height, List<String> hobbies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sal = sal;
		this.gender = gender;
		this.height = height;
		this.hobbies = hobbies;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", sal=" + sal + ", gender=" + gender
				+ ", height=" + height + ", hobbies=" + hobbies + "]";
	}

}
