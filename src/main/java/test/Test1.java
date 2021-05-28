package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@FunctionalInterface
interface MyFunctionalInterface{
	public String hi(String name);
	//public String hello(String name);
}

public class Test1 {

	public static void main(String[] args) {
		MyFunctionalInterface obj = (name) ->  {return "Hello:"+name;};
		String res = obj.hi("Reshma");
		System.out.println(res);
		
		//displays items having more than 1 occurances.
		Set s  = null;
		ArrayList<Integer> list= new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(1);

		int count=0;
		for(int i=0;i<list.size();i++){
		for(int j=i+1;j<list.size();j++){

		if(list.get(i)==list.get(j)){
		count++;
		}
		if(count>0){
			s  = new HashSet();
			s.add(list.get(i));
			count=0;
		}
		
		}

		}
		
		
	}
	
	

}
