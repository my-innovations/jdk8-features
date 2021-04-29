package optional;

import java.util.Optional;

public class App08_Optional_class_01 {

	public Integer sum(Optional<Integer> num1, Optional<Integer> num2) {
		// Optional.isPresent - checks the value is present or not

		System.out.println("First parameter is present: " + num1.isPresent());
		System.out.println("Second parameter is present: " + num2.isPresent());

		// Optional.orElse - returns the value if present otherwise returns the default value passed.
		Integer value1 = num1.orElse(new Integer(0));

		// Optional.get - gets the value, value should be present
		Integer value2 = num2.get();

		return value1 + value2;
	}

	public static void main(String[] args) {
		
		 //################################################################
		//Optional orElse() and orElseGet() methods
		
		//Creating Optional object from a String
        Optional<String> GOT = Optional.of("Game of Thrones");        
        //Optional.empty() creates an empty Optional object        
        Optional<String> nothing = Optional.empty();

        //orElse() method
        System.out.println(GOT.orElse("Default Value")); 
        System.out.println(nothing.orElse("Default Value")); 

        //orElseGet() method
        System.out.println(GOT.orElseGet(() -> "Default Value")); 
        System.out.println(nothing.orElseGet(() -> "Default Value")); 
        
        //################################################################
        //Optional.map and Optional.flatMap
        //Creating Optional object from a String       
        Optional<String> GOT2 = Optional.of("Game of Thrones");       
        //Optional.empty() creates an empty Optional object       
        Optional<String> nothing2 = Optional.empty();
        System.out.println(GOT2.map(String::toLowerCase));        
        System.out.println(nothing2.map(String::toLowerCase));
        Optional<Optional<String>> anotherOptional = Optional.of(Optional.of("BreakingBad"));        
        System.out.println("Value of Optional object"+anotherOptional);        
        System.out.println("Optional.map: "  +anotherOptional.map(gender -> gender.map(String::toUpperCase)));        
        //Optional<Optional<String>>    -> flatMap -> Optional<String>        
        System.out.println("Optional.flatMap: " +anotherOptional.flatMap(gender -> gender.map(String::toUpperCase)));
		
      //################################################################
		//Optional with filter
      //Creating Optional object from a String       
        Optional<String> GOT3 = Optional.of("Game of Thrones");              
        /* Filter returns an empty Optional instance if the output doesn't         
         * contain any value, else it returns the Optional object of the          
         * given value.         
         */        
        System.out.println(GOT3.filter(s -> s.equals("GAME OF THRONES")));         
        System.out.println(GOT3.filter(s -> s.equalsIgnoreCase("GAME OF THRONES")));
        
		//###############################################################
		App08_Optional_class_01 java8Tester = new App08_Optional_class_01();

		Integer value1 = null;
		Integer value2 = new Integer(10);

		// Optional.ofNullable - allows passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);

		// Optional.of - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);

		System.out.println(java8Tester.sum(a, b));
	}
}
