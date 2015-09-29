import java.util.*;
import java.io.*;

public class getPermutations {
	public static ArrayList<String> getPurmutations(String word) {
		// Returns an ArrayList of all possible permutations of the word
		ArrayList<String> listOfPerms = new ArrayList<String>();
		if (word == null || word == "") {
			return listOfPerms;
		}
		getPermsHelper("", word, listOfPerms);
		return listOfPerms;
	}
	public static void getPermsHelper(String prefix, String word, ArrayList<String> listOfPerms) {
		if (word.length()==0) {
			listOfPerms.add(prefix);
			return;
		}
		for (int i=0; i<word.length(); i++) {
			getPermsHelper(prefix+word.charAt(i), word.substring(0, i) + word.substring(i+1), listOfPerms);
		}
	}
	public static void main(String[] args) {
		System.out.println(getPurmutations("hi"));
		System.out.println(getPurmutations("mother"));
		System.out.println(getPurmutations("abc"));
	}
}