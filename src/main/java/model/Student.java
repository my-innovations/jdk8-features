package model;

import java.util.Comparator;

public class Student implements Comparator<Student> {

	private Integer rollNo;
	private String name;

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getRollNo() > o2.getRollNo())
			return 1;
		else if (o1.getRollNo() < o2.getRollNo())
			return -1;
		return 0;
	}

}
