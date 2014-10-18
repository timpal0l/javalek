
public class reverseString {

	public static String revString(String string) {

		char[] array1 = new char[string.length()];

		int end = string.length() - 1;
		int start = 0;

		while (start < string.length()) {
			array1[start] = string.charAt(end);
			start++;
			end--;
		}

		return new String(array1);
	}

	public static void main(String[] args) {
		System.out.println(revString("smart arab"));
	}

}
