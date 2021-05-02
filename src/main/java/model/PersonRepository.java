package model;

import java.util.Arrays;
import java.util.List;

public class PersonRepository {
	
	//returning single person record
	public static Person getPerson() {
		return new Person(1,"punyasmruti","nayak",1000D,"male",30,100,Arrays.asList("reading","music"));
	}

	//returns list
	public static List<Person> getAllPesons(){
		return Arrays.asList(
				new Person(1,"punyasmruti","nayak",1000D,"male",40,100,Arrays.asList("reading","music")),
				new Person(2,"omkar","nayak",2000D,"male",4,50,Arrays.asList("cartoon ")),
				new Person(3,"Partha","beuria",3000D,"male",41,110,Arrays.asList("cricket","music")),
				new Person(4,"Niraj","pandey",4000D,"male",35,120,Arrays.asList("caroom","music"))
				);
	}
}
