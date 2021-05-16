package test;

public class StringPalindromeTest {

	public static void main(String[] args) {

		String s = "abcbav";

		char[] inArr = s.toCharArray();
		char[] outArr = new char[s.length()];

		for (int i = inArr.length - 1, j = 0; i >= 0; i--, j++) {
			outArr[j] = inArr[i];
		}

		String s2 = new String(outArr);

		if (s.equalsIgnoreCase(s2)) {
			System.out.println("pal");
		} else {
			System.out.println("not pal");
		}
	}
}
