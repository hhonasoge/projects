import java.util.*;

public class Recursion{
	public static int countWaysUpStairs(int n){
		if (n<0)return 0;
		else if (n==0) return 1;
		else return countWaysUpStairs(n-1) + countWaysUpStairs(n-2) + countWaysUpStairs(n-3);
	}
	public static int countWaysMemo(int n){
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return countWaysMemo(n, memo);
	}
	public static int countWaysMemo(int n, int[] memo){
		if (n<=0)return 0;
		else if (n==0) return 1;
		else if (memo[n]>-1){
			return memo[n];
		}
		else memo[n] = countWaysUpStairs(n-1) + countWaysUpStairs(n-2) + countWaysUpStairs(n-3);
		return memo[n];
	}
	public static ArrayList<ArrayList<Integer>> allSubsets(ArrayList<Integer> set){
		return allSubsets(set, set);
	}
	public static ArrayList<ArrayList<Integer>> allSubsets(ArrayList<Integer> set, ArrayList<Integer> setClone){
		if (setClone.size()==0){
			ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
			// System.out.println(allSubsets.size());
			return allSubsets;
		}
		int lastElement = setClone.remove(setClone.size()-1);
		System.out.println(lastElement);
		ArrayList<ArrayList<Integer>> allSubsets = allSubsets(set, setClone);
		ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> tmpSet : allSubsets){
			ArrayList<Integer> newSubset = new ArrayList<Integer>();
			newSubset.addAll(tmpSet);
			newSubset.add(lastElement);
			moreSubsets.add(newSubset);
		}
		allSubsets.addAll(moreSubsets);
		return allSubsets;
	}
	public static int multiply(int m, int n){
		//O(n) space and time
		if (n==0){
			return 0;
		}
		return m + multiply(m, n-1);
	}
	public static int multiplyImproved(int m, int n){
		//O(Math.min(m, n)) space and time
		return (m>=n) ? multiply(m, n) : multiply(n, m);
	}
	public static ArrayList<String> allPermsOfString(String input){
		HashSet<String> stringSet = new HashSet<String>();
		return allPermsOfString(input, stringSet);
	}
	public static ArrayList<String> allPermsOfString(String input, HashSet<String> stringSet){
		if (input.length()==0) return null;
		if (input.length()==1) {
			ArrayList<String> rv =  new ArrayList<String>();
			rv.add(input);
			return rv;
		}
		char lastChar = input.charAt(input.length()-1);
		String inputMinusOne = input.substring(0, input.length()-1);
		ArrayList<String> tmp = allPermsOfString(inputMinusOne);
		ArrayList<String> newStringList = new ArrayList<String>();
		for (String u : tmp){
			for (int i=0; i<=u.length(); i++){
				String x = u.substring(0, i) + lastChar + u.substring(i, u.length());
				if (!stringSet.contains(x)){
					newStringList.add(x);
					stringSet.add(x);
				}
			}
		}
		return newStringList;
	}
	public static void main(String[] args){
		System.out.println(countWaysMemo(10));
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		ArrayList<ArrayList<Integer>> allSubsets = allSubsets(testList);
		for (int i=0; i<allSubsets.size();i++){
			System.out.println("==========");
			for (int j=0; j<allSubsets.get(i).size();j++){
				System.out.println("           " + allSubsets.get(i).get(j));
			}
		}
		System.out.println(multiplyImproved(10, 19));
		ArrayList<String> testAllPerms = allPermsOfString("");
		for (String u : testAllPerms){
			System.out.println(u);
		}
	}
}