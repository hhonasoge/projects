import java.util.*;

public class Moderate{
	public static void swap(int[] arr, int a, int b){
		if (a>arr.length-1||b>arr.length-1|a<0|b<0) return;
		arr[a] = arr[a]-arr[b];
		arr[b] = arr[a] + arr[b];
		arr[a] = arr[b] - arr[a];
	}
	public static int smallestDifferenceBrute(int[] a, int[] b){
		int minDiff = Integer.MAX_VALUE;
		for (int i=0; i<a.length;i++){
			int curr = a[i];
			for (int j=0; j<b.length; j++){
				int diff = Math.abs(curr - b[j]);
				if (diff<minDiff){
					minDiff = diff;
				}
			}
		}
		return minDiff;
	}
	public static int smallestDifferenceOptimal(int[] a, int[] b){
		Arrays.sort(a);
		Arrays.sort(b);
		int acount = 0;
		int bcount = 0;
		int minDiff = Integer.MAX_VALUE;
		while(acount<a.length && bcount < b.length){
			int diff = Math.abs(a[acount] - b[bcount]);
			minDiff = Math.min(minDiff, diff);
			if (a[acount]>b[bcount]){
				bcount++;
			} else {
				acount++;
			}
		}
		return minDiff;
	}
	public static int findMax(int a, int b){
		int c = a-b;
		int i = c>>31;
		return a + i*c;
	}
	public static void main(String[] args){
		int[] test = {1, 2, 3, 4};
		swap(test, 1, 2);
		for (int i=0; i<test.length; i++){
			System.out.print("   " + test[i]);
		}
		System.out.println("   ");
		System.out.println("============");
		int[] a = {1, 3, 15, 11, 2};
		int[] b = {23, 127, 235, 19, 8};
		System.out.println("smallestDifferenceBrute: " + smallestDifferenceBrute(a, b));
		System.out.println("smallestDifferenceOptimal: " + smallestDifferenceOptimal(a, b));
		System.out.println(findMax(5, 3));
	}
}