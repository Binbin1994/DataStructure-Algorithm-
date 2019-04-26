package stringMatch;

import java.util.Arrays;

public class StringMatch {
	private String mainString = "hello";

	public boolean bfMatch(String string) {
		for (int i = 0; i <= mainString.length() - string.length(); i++) {
			for (int j = 0; j < string.length(); j++) {
				if (string.charAt(j) != mainString.charAt(j + i)) {
					break;
				}
				if (j == string.length() - 1) {
					return true;
				}
			}
		}
		return false;
	}

	public void reverseString() {
		char[] myNameChars = mainString.toCharArray();
		int mid = (myNameChars.length - 1) / 2;
		int pos = myNameChars.length - 1;
		for (int i = 0; i < myNameChars.length; i++) {
			if (i == mid && (myNameChars.length & 1) != 0) {
				break;
			}
			char word = myNameChars[i];
			myNameChars[i] = myNameChars[pos - i];
			myNameChars[pos - i] = word;

		}
		this.mainString=String.valueOf(myNameChars);        

	}

	public void print() {
		System.out.println(mainString);
	}

	public static void main(String[] args) {

		StringMatch match = new StringMatch();
		System.out.println(System.currentTimeMillis());
		System.out.println(match.bfMatch("lo"));
		match.reverseString();
	    match.print();
	    System.out.println(match.bfMatch("lo"));
		System.out.println(System.currentTimeMillis());

	}
}
