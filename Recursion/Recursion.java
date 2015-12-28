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
	public static ArrayList<String> generateParens(int numParens){
		if (numParens==0)return new ArrayList<String>();
		if (numParens==1){
			ArrayList<String> newList = new ArrayList<String>();
			newList.add("()");
			return newList;
		}
		ArrayList<String> prevList = generateParens(numParens-1);
		ArrayList<String> updatedList = new ArrayList<String>();
		for (String u : prevList){
			for (int i=0; i<u.length();i++){
				if (u.charAt(i)=='('){
					String newString = u.substring(0,i+1) + "()" + u.substring(i+1, u.length());
					if (!updatedList.contains(newString)){
						updatedList.add(newString);
					}
				}
			}
			if (!updatedList.contains("()"+u)){
				updatedList.add("()"+u);
			}
		}
		return updatedList;
	}
	public static ArrayList<String> generateParens2(int numParens){
		ArrayList<String> newStringList = new ArrayList<String>();
		char[] str = new char[numParens*2];
		generateParens2(newStringList, numParens, numParens, str, 0);
		return newStringList;
	}
	public static void generateParens2(ArrayList<String> newStringList, int leftRem, int rightRem, char[] str, int count){
		if (leftRem<0||rightRem<leftRem) return;
		if (leftRem==0&&rightRem==0){
			newStringList.add(str.toString());
		} else {
			if (leftRem>0){
				str[count] = '(';
				generateParens2(newStringList, leftRem-1, rightRem, str, count+1);
			}
			if (rightRem>0){
				str[count] = ')';
				generateParens2(newStringList, leftRem, rightRem-1, str, count+1);
			}
		}
	}
	public static int makeChange(int n){
		if (n==0){return 0;}
		ArrayList<HashMap<Integer, Integer>> hashMap = new ArrayList<HashMap<Integer, Integer>>();
		return makeChangeHelp(n, 0, 0, 0, 0, hashMap);
	}
	public static int makeChangeHelp(int n, int quarters, int dimes, int nickels, int pennies, ArrayList<HashMap<Integer, Integer>> hashMap){
		if (n<0){return 0;}
		if (n==0){
			int numSame = 0;
			for (HashMap<Integer, Integer> map : hashMap) {
				if (map.get(25)==quarters){
					numSame+=1;
				}
				if (map.get(10)==dimes){
					numSame+=1;
				}
				if (map.get(5)==nickels){
					numSame+=1;
				}
				if (map.get(1)==pennies){
					numSame+=1;
				}
				if (numSame==4){
					return 0;
				}
				numSame=0;
			}
			HashMap<Integer, Integer> newMap = new HashMap<Integer, Integer>();
			newMap.put(25, quarters);
			newMap.put(10, dimes);
			newMap.put(5, nickels);
			newMap.put(1, pennies);
			hashMap.add(newMap);
			return 1;
		}
		int ways = 0;
		if (n-25>=0){
			ways+=makeChangeHelp(n-25, quarters+1, dimes, nickels, pennies, hashMap);
		}
		if (n-10>=0){
			ways+=makeChangeHelp(n-10, quarters, dimes+1, nickels, pennies, hashMap);
		}
		if (n-5>=0){
			ways+=makeChangeHelp(n-5, quarters, dimes, nickels+1, pennies, hashMap);
		}
		if (n-1>=0){
			ways+=makeChangeHelp(n-1, quarters, dimes, nickels, pennies+1, hashMap);
		}
		return ways;
	}
	public static ArrayList<Integer[]> placeQueens(){
		ArrayList<Integer[]> finalList = new ArrayList<Integer[]>();
		Integer[] list = new Integer[8];
		placeQueens(finalList, list, 0);
		return finalList;
	}
	public static void placeQueens(ArrayList<Integer[]> finList, Integer[] list, int rows){
		if (rows==8){
			finList.add(list.clone());
		} else {
			for (int col=0; col<8;col++){
				if (isValid(list, rows, col)){
					list[rows] = col;
					placeQueens(finList, list, rows+1);
				}
			}
		}
	}
	public static boolean isValid(Integer[] list, int row, int col){
		for (int rowSet=0; rowSet<row; rowSet++){
			int colSet = list[rowSet];
			if (colSet==col){
				return false;
			}
			if (row-rowSet==Math.abs(col-colSet)){
				return false;
			}
		}
		return true;
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
		ArrayList<Integer> testagain = new ArrayList<Integer>();
		testagain.add(1);
		testagain.add(0);
		Collections.sort(testagain);
		for (int i=0; i<testagain.size();i++){
			System.out.println(testagain.get(i));
		}
		System.out.println(multiplyImproved(10, 19));
		ArrayList<String> testAllPerms = allPermsOfString("a");
		for (String u : testAllPerms){
			System.out.println(u);
		}
		ArrayList<String> testListt = generateParens(5);
		for (String u : testListt){
			System.out.println(u);
		}
		System.out.println(makeChange(10));
		System.out.println("++++++++++++");
		ArrayList<Integer[]> finalList = placeQueens();
		for (Integer[] x : finalList){
			for (int i=0; i<x.length;i++){
				System.out.println(x[i]);
			}
			System.out.println("============");
		}
	}
}