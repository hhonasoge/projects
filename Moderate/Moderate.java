import java.util.*;

public class Moderate{
	public static void swap(int[] arr, int a, int b){
		if (a>arr.length-1||b>arr.length-1|a<0|b<0) return;
		arr[a] = arr[a]-arr[b];
		arr[b] = arr[a] + arr[b];
		arr[a] = arr[b] - arr[a];
	}
	public static void main(String[] args){
		int[] test = {1, 2, 3, 4};
		swap(test, 1, 2);
		for (int i=0; i<test.length; i++){
			System.out.print("   " + test[i]);
		}
	}
}