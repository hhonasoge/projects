import java.util.*;

public class playWStrings {
	public static void main (String[] args) {
		String s = "harsha";
		String d = "aaRsha";
		System.out.println(s.equals(d));
		System.out.println(d.trim());
		System.out.println(s.equals(d.trim()));
		System.out.println(s.substring(0, 1));
		System.out.println(s.replace("rs", "ab"));
		// System.out.println(s.regionMatches(true, 1, d, 5));
		System.out.println(s.lastIndexOf('a'));
		System.out.println((int)'?');
		// System.out.println(String.valueOf(5));
	}
}