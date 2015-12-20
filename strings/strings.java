import java.util.*;
/*
Important functions:
	charAt()
	endsWith
	startsWith
	contains
	compareTo
	hashCode
	equals
	indexOf
	lastIndexOf
	length
	replace
	trim
	toUpperCase
	toLowerCase
	substring
	toCharArray
	toString



*/
public class strings {
	public static void main(String[] args) {
		String test = "Harsha";
		System.out.println(test + "Honasoge");
		for (int i=0; i<test.length(); i++){
			System.out.println(test.charAt(i));
		}
		System.out.println(test.compareTo("Honasoge")=='a'-'o');
		System.out.println(test.contains("arsa"));
		System.out.println(test.equals("Harsha"));
		System.out.println(test.hashCode());
		System.out.println(test.endsWith("ha"));
		System.out.println(test.indexOf("a", 2));
		System.out.println(test.substring(0));
		System.out.println(test.toString());
		System.out.println(test.toCharArray()[0]);
	}
}