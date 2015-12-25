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
	public static void main(String[] args){
		System.out.println(countWaysMemo(10));
	}
}