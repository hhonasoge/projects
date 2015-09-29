import java.io.*;
import java.lang.String;
import java.util.*;

/*public boolean hasUniqueChars(String word){
  for (int i=0; i<word.length();i++) {
    char tmp = word.charAt(i);
  }
  return false;
}*/
public class uniqueChars {
	public static boolean hasUniqueChars1(String word) {
		// O(N) worst case. N = length of word
		ArrayList<Character> charList = new ArrayList<Character>();
		for (int i=0; i<word.length(); i++) {
			if (charList.contains(word.charAt(i))) {
				return false;
			} else {
				charList.add(word.charAt(i));
			}
		}
		return true;
	}
	public static boolean hasUniqueChars2(String word) {
		// O(N^2) worst case. N = length of word
		for (int i=0; i<word.length(); i++) {
			char tmp = word.charAt(i);
			for (int j=i+1; j<word.length(); j++) {
				if (word.charAt(j)==tmp){
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args){
  		System.out.println(hasUniqueChars2("Harsha"));
  		System.out.println(hasUniqueChars2("abcdefg"));
	}
}
