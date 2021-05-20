package interface_changes;

//NOte:
//we can write any no of default and static methods inside an interface.
//we can override interface's default method in child classes but not static methods.
//we should not override interface static method in sub classes due to some security violations.
//we can not call non static method from static method and variable in interface.//CE

//static method in interface can not be empty.
//static method can be accessed by directly by interface name.
//static method in interface is called as utility method.



interface MyInterface1 {

	public abstract void exsistingMethod(String str);// SAM

	default public void default_method1() {
		System.out.println("from default method1 - MyInterface1");
	}

	default public String default_method2() {
		return "from default method2 - MyInterface1";
	}

	default public int default_method3_add(int x, int y) {
		return x + y;
	}

	static public void static_method1() {
		System.out.println("from static method1 - myinterface1");
	}

	static public String static_method2() {
		return "from static method2 - myinterface1";
	}
}

interface MyInterface2 {

	// default method
	default public void default_method1() {
		System.out.println("from default method1 - MyInterface2");
	}

	// static method
	static public void static_method1() {
		System.out.println("from static method1 - MyInterface2");
	}
}

//##########################################################################################################

class MyClass1 implements MyInterface1 {

	//overriden abstact method from interface.
	@Override
	public void exsistingMethod(String str) {
		System.out.println(str);
	}
	
	//overriden default method from interface.
	public void default_method1() {
		System.out.println("from default method1 - Myclass1");
	}
	
	//overriden static method from interface MyInterface1.
	static public void static_method1() {
		System.out.println("from static method1 - Myclass1");
		MyInterface1.static_method1();
	}
	
	//other concrete methods
	public void myMethod1() {
		default_method1();
	}

	public String myMethod2() {
		return default_method2();
	}

	public int add_method(int x, int y) {
		return default_method3_add(x, y);
	}
}

class MyClass2 implements MyInterface1, MyInterface2 {

	@Override
	public void exsistingMethod(String str) {
		System.out.println("Hello:" + str);
	}

	// ovverriding default method of both MyInterface1, MyInterface2 in child class.
	@Override
	public void default_method1() {

		//calling default method
		//default_method1(); //CE
		MyInterface1.super.default_method1();
		MyInterface2.super.default_method1();

		//calling static method
		MyInterface1.static_method1();
		MyInterface2.static_method1();
	}

	// ovverriding static method in child class from MyInterface1,MyInterface2.
	//not recomended 
	static public void static_method1() {
		MyInterface1.static_method1();
		MyInterface2.static_method1();
	}
}

public class Interface_Changes_in_jdk8 {
	
	public static void main(String[] args) {

		// calling static methods of interface1
		MyInterface1.static_method1();
		System.out.println(MyInterface1.static_method2());

		MyClass1.static_method1();

		MyClass1 obj = new MyClass1();

		// calling implemented abstract method
		obj.exsistingMethod("Hello");

		obj.myMethod1();

		int res = obj.add_method(10, 20);
		System.out.println(res);

		// calling default method
		obj.default_method1();
	}
}
