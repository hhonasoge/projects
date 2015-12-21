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
Other notes:
	in ASCII, 'A' is 65 and 'Z' is 90, a' is 97 and 'z' is 122
*/
public class strings {
	public static boolean hasUniqueChars1(String input){
		//O(n) time where n is the length of input
		//O(n) space where n is the length of input
		if (input==null){
			return false;
		}
		ArrayList<Character> charList = new ArrayList<Character>();
		for (int i=0; i<input.length(); i++){
			if (charList.contains(input.charAt(i))){
				return false;
			} else {
				charList.add(input.charAt(i));
			}
		}
		return true;
	}
	public static boolean hasUniqueChars2(String input){
		//O(1) space
		//O(n) time
		if (input==null){
			return false;
		}
		long bitVector = 0;
		for (int i=0; i<input.length(); i++){
			int iChar = input.charAt(i) - 'A';
			if (getBit(bitVector, iChar)==1){
				return false;
			} else {
				bitVector = setBit(bitVector, iChar);
			}
		}
		return true;
	}
	public static int getBit(long bitVector, int i){
		long iBitVector = (1L<<i);
		return (iBitVector&bitVector)==0 ? 0 : 1;
	}
	public static long setBit(long bitVector, int i){
		long iBitVector = 1L<<i;
		return bitVector|iBitVector;
	}
	public static void print(Object input){
		System.out.println(input);
	}
	// public class newClass extends Collection {
	// 	int a, b;
	// 	public newClass(int a, int b){
	// 		this.a = a;
	// 		this.b = b;
	// 	}
	// }
	public static boolean isPermutation(String a, String b){
		//O(nlogn + mlogm) time
		//O(m + n) space
		char[] aCharArray = a.toCharArray();
		char[] bCharArray = b.toCharArray();
		Arrays.sort(aCharArray);
		Arrays.sort(bCharArray);
		String sortedA = new String(aCharArray);
		String sortedB = new String(bCharArray);
		return (sortedA.equals(sortedB));
	}
	public static boolean isPermutation2(String a, String b){
		//O(1) space
		//O(n+m) time
		if (a.length()!=b.length())return false;
		int[] charArray = new int[128];
		for (int i=0; i<a.length(); i++){
			charArray[(int)a.charAt(i)-'a']++;
		}
		for (int i=0;i<b.length();i++){
			charArray[(int)b.charAt(i)-'a']--;
			if (charArray[(int)b.charAt(i)-'a'] < 0){
				return false;
			}
		}
		return true;
	}
	public static void URLify(char[] str, int length){
		int spaceCount = 0;
		int newLength;
		for (int i=0; i<length; i++){
			if (str[i]==' '){
				spaceCount++;
			}
		}
		newLength = length + spaceCount*2;
		// str[newLength]='\0';
		for (int i=length-1; i>=0;i--){
			if (str[i]==' '){
				str[newLength-1]='0';
				str[newLength-2]='2';
				str[newLength-3]='%';
				newLength=newLength - 3;
			} else {
				str[newLength-1] = str[i];
				newLength=newLength - 1;
			}
		}
	}
	public static boolean isPalPermutation1(String input){
		HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
		for (int i=0; i<input.length();i++){
			if (!charCount.containsKey(input.charAt(i))||charCount.get(input.charAt(i))==0){
				charCount.put(input.charAt(i), 1);
			} else {
				charCount.put(input.charAt(i),0);
			}
		}
		boolean maxOneOdd = false;
		for (Character key: charCount.keySet()){
			if (charCount.get(key)!=0){
				if (!maxOneOdd){
					maxOneOdd=true;
				} else {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isOneEditAway(String a, String b){
		int alen = a.length();
		int blen = b.length();
		int difflen = alen-blen;
		if (difflen>1||difflen<-1){
			return false;
		} else if (difflen==0){
			return checkReplace(a, b);
		} else if (difflen>0){
			return checkRemove(a, b);
		} else {
			return checkRemove(b, a);
		}
	}
	public static boolean checkReplace(String a, String b){
		boolean maxOneDiff = false;
		for (int i=0; i<a.length(); i++){
			if (a.charAt(i)!=b.charAt(i)){
				if (maxOneDiff){
					return false;
				} else {
					maxOneDiff=true;
				}
			}
		}
		return true;
	}
	public static boolean checkRemove(String longer, String shorter){
		int longIndex=0;
		int shortIndex=0;
		boolean maxOneDiff = false;
		while(longIndex<longer.length()&&shortIndex<shorter.length()){
			if (longer.charAt(longIndex)!=shorter.charAt(shortIndex)){
				if (maxOneDiff){
					return false;
				} else {
					longIndex++;
				}
			} else {
				longIndex++;
				shortIndex++;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String test="Harsha";
		String test2 = "asdfg";
		String test3 = "";
		String test4=null;
		String test5 = "aA";


		// System.out.println("Before");
		// String x = args[0].toLowerCase();
		// HashSet<Character> contents = new HashSet<Character>();

		// for (int i =0; i < x.length(); i++) {
		// 	char b = x.charAt(i);
		// 	if (contents.contains(b)) {
		// 		System.out.println("false");
		// 		break;
		// 	} else {
		// 		contents.add(b);
		// 	}
		// }
		// System.out.println("After");
		print(hasUniqueChars2(test));//false
		print(hasUniqueChars2(test2));//true
		print(hasUniqueChars2(test3));//true
		print(hasUniqueChars2(test4));//false
		print(hasUniqueChars2(test5));//true

		print("-------");
		print(isPermutation2("harsha", "arshah"));
		print(isPermutation2("asfjw", "alkfgwe"));
		print("--------");

		String test6 = "Hars  ha";
		char[] test6_2 = new char[test6.length()+4];
		for (int i=0;i<test6.length();i++){
			test6_2[i]=test6.charAt(i);
		}
		// print(test6_2[4]);
		// // print(test6_2.toString());
		URLify(test6_2, 8);
		test6= new String(test6_2);
		System.out.println(test6_2);
		print("---------");
		print(isPalPermutation1("racecar"));
		print(isPalPermutation1("abc"));

		HashMap<Integer, Integer> squares = new HashMap<Integer, Integer>();
		for (int i=0; i<25; i++){
			squares.put(i, i*i);
		}
		Iterator<Map.Entry<Integer, Integer>> entries = squares.entrySet().iterator();
		while (entries.hasNext()){
			print(entries.next());
		}
		print("----------");
		print(isOneEditAway("Harsha", "arsha"));
		print(isOneEditAway("", "alaksuhg"));
		print(isOneEditAway("pale", "ple"));
		print(isOneEditAway("pales", "pale"));
		print(isOneEditAway("pale", "bale"));
		print(isOneEditAway("pale", "bake"));
		// newClass a = new newClass();
		// Class c = test.getClass();
		// System.out.println(b instanceof String);
		// System.out.println(test + "Honasoge");
		// for (int i=0; i<test.length(); i++){
		// 	System.out.println(test.charAt(i));
		// }
		// System.out.println(test.compareTo("Honasoge")=='a'-'o');
		// System.out.println(test.contains("arsa"));
		// System.out.println(test.equals("Harsha"));
		// System.out.println(test.hashCode());
		// System.out.println(test.endsWith("ha"));
		// System.out.println(test.indexOf("a", 2));
		// System.out.println(test.substring(0));
		// System.out.println(test.toString());
		// System.out.println(test.toCharArray()[0]);
	}
}