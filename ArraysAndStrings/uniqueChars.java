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

	public static void main(String[] args){
  		System.out.println(hasUniqueChars1("Harsha"));
  		System.out.println(hasUniqueChars1("abcdefg"));
	}
}
