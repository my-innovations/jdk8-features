package stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
	
	private static List<UserRegistration> usersList = null;
	private static Long id = 0l;
	
	static {
		UserRegistration user1 = new UserRegistration();
		user1.setUserId(++id);
		user1.setFirstname("Punyasmruti");
		user1.setLastname("Nayak");
		user1.setEmail("punyasmruti@gmail.com");
		user1.setAge(25);
		user1.setMobileNos(Arrays.asList(9962428121L, 6383609193L));
		user1.setDob(new Date(1980,5,15));//ok
		/*
		 * try { user1.setDob(new SimpleDateFormat("dd MMM yyyy").parse("11 May 1980"));
		 * //user1.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("11/05/1980"));//ok }
		 * catch (ParseException e) { e.printStackTrace(); }
		 */
		

		UserRegistration user2 = new UserRegistration();
		user2.setUserId(++id);
		user2.setFirstname("Parthasarathi");
		user2.setLastname("Beuria");
		user2.setEmail("parthasarathi@gmail.com");
		user2.setAge(45);
		user2.setMobileNos(Arrays.asList(12345L));
		user2.setDob(new Date(1980,5,11));//ok
		/*
		 * try { //user2.setDob(new
		 * SimpleDateFormat("dd MMM yyyy").parse("25 Nov 1979")); //user2.setDob(new
		 * SimpleDateFormat("dd/MM/yyyy").parse("15/05/1980"));//ok
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		
		

		usersList = new ArrayList<>();
		usersList.add(user1);
		usersList.add(user2);

	}

	public static void main(String[] args) {
		
		//List list = getUsersByAge_WithFirstnameInDescendingOrder();
		//System.out.println(list);
		
		//List<UserRegistration> list2 = getUsersByMobileNo(6383609193L);
		//System.out.println(list2);
		
		List<UserRegistration> list3 = getUsersByBirthDate_WithFirstnameInDescendingOrder2();
		System.out.println(list3);
	}

public static List<UserRegistration> getUsersByAge_WithFirstnameInDescendingOrder() {
		return usersList
				.stream()
				.filter(user -> user.getAge() > 30 && user.getAge() < 50)
				.sorted(Comparator.comparing(UserRegistration::getFirstname).reversed())
				.collect(Collectors.toList());
	}

public static List<UserRegistration> getUsersByMobileNo(Long MobileNo) {
	Predicate<UserRegistration> p1 = user -> user.getMobileNos().contains(MobileNo);
	return usersList
			.stream()
			.filter(p1)
			.collect(Collectors.toList());
}

public static List<UserRegistration> getUsersByBirthDate_WithFirstnameInDescendingOrder2() {
	
	return usersList
			.stream()
			.filter(user -> user.getDob().getMonth() == 5 && user.getDob().getDate() == 15 )
			.sorted(Comparator.comparing(UserRegistration::getFirstname).reversed())
			.collect(Collectors.toList());
}

}
