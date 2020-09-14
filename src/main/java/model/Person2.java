package model;

public class Person2 {
	
	public String name;

	public Person2(String name) {
		this.name = name;
	}

	public static int animalCompare(Person2 a1, Person2 a2) {
		return a1.name.compareTo(a2.name);
	}

	@Override
	public String toString() {
		return name;
	}

}
