package model;

import java.util.Arrays;
import java.util.List;

public class PersonRepository {

	public static List<Person> getAllPesons(){
	
		return Arrays.asList(
				new Person("punyasmruti","nayak",1000D,"male",100,Arrays.asList("reading","music")),
				new Person("omkar","nayak",2000D,"male",50,Arrays.asList("cartoon ")),
				new Person("Partha","beuria",3000D,"male",110,Arrays.asList("cricket","music")),
				new Person("Niraj","pandey",4000D,"male",120,Arrays.asList("caroom","music"))
				);
	}
	
	public static Person getPerson() {
		return new Person("punyasmruti","nayak",1000D,"male",100,Arrays.asList("reading","music"));
	}

}
