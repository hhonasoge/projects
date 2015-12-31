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
	public static int findTrailingZeros(int nFactorial){
		if (nFactorial<=4)return 0;
		int count=0;
		for (int i=nFactorial; i>4; i--){
			count+=numFactorsOfFive(i);
		}
		return count;
	}
	public static int numFactorsOfFive(int n){
		int count = 0;
		while (n%5==0){
			count++;
			n=n/5;
		}
		return count;
	}
	public static String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public static String hundred = "Hundred";
	public static String[] bigs =  {"", "Thousand", "Million", "Billion"};
	public static String convert(int num){
		if (num==0){
			return smalls[0];
		}
		if (num<0){
			return "Negative" + convert(-1*num);
		}
		String convertedString = "";
		int bigCounter = 0;
		while (num>0){
			if (num%1000!=0){
				convertedString = convertChunk(num%1000) + " "+ bigs[bigCounter] + " " + convertedString;
				bigCounter++;
			}
			num /= 1000;
		}
		return convertedString;
	}
	public static String convertChunk(int num){
		String chunkString = "";
		if (num>=100){
			chunkString+= smalls[num/100] + " " +hundred;
			num %= 100;
		}
		if (num>=10 && num <=19){
			chunkString+=smalls[num];
		} else if (num >= 20){
			chunkString+=" " + tens[num/10];
			num%=10;
		}
		if (num>=0 && num<=9){
			chunkString+=" " + smalls[num];
		}
		return chunkString;
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
		System.out.println(findTrailingZeros(10));
		System.out.println(convert(-1234));
	}
}