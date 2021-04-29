package test;

import java.util.HashMap;

public class CountNoOfCharactersInAString {
	public static void main(String[] args) {
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		String inputString = "punya";
		char[] strArray = inputString.toCharArray();
		for (char c : strArray) {
			if (charCountMap.containsKey(c)) {
				charCountMap.put(c, charCountMap.get(c) + 1);
			} else {
				charCountMap.put(c, 1);
			}
		}
		System.out.println(inputString + " : " + charCountMap);
	}
}
