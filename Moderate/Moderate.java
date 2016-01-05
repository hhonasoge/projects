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
	public static int findMaxSum(int[] arr){
		int currSum, maxSum;
		currSum=maxSum=0;
		for (int i=0;i<arr.length;i++){
			if (arr[i]>=0){
				currSum+=arr[i];
				if (currSum>maxSum){
					maxSum=currSum;
				}
			} else {
				currSum=Math.max(currSum+arr[i], 0);
			}
		}
		return maxSum;
	}
	public static boolean matchesPattern(String value, String pattern){
		int patternLength = pattern.length();
		if (patternLength==0) return false;
		char mainChar = pattern.charAt(0);
		char altChar = mainChar == 'a' ? 'b' : 'a';
		int countMain = countOf(pattern, mainChar);
		int countAlt = patternLength - countMain;
		int valueSize = value.length();
		int maxMainSize = valueSize/countMain;
		int firstAlt = pattern.indexOf(altChar);
		for (int mainSize =0; mainSize < maxMainSize; mainSize++){
			int remainingLength = valueSize - mainSize*countMain;
			String first = value.substring(0, mainSize);
			if (countAlt==0||remainingLength%countAlt==0){
				int altSize = countAlt==0 ? 0 : remainingLength/countAlt;
				int altIndex = firstAlt*mainSize;
				String second = countAlt==0 ? "" : value.substring(altIndex, altSize+altIndex);
				String cand = buildFromPattern(pattern, first, second);
				if (cand.equals(value)){
					return true;
				}
			}

		}
		return false;

	}
	public static String buildFromPattern(String pattern, String first, String second){
		StringBuffer sb = new StringBuffer();
		char firstChar = pattern.charAt(0);
		for (char c : pattern.toCharArray()){
			if (c==firstChar){
				sb.append(first);
			} else {
				sb.append(second);
			}
		}
		return sb.toString();
	}
	public static int countOf(String pattern, char mainChar){
		int count=0;
		for (int i=0; i<pattern.length(); i++){
			if (pattern.charAt(i)==mainChar){
				count++;
			}
		}
		return count;
	}
	public static ArrayList<Integer> computePondSizes(int[][] land){
		ArrayList<Integer> pondSizes = new ArrayList<Integer>();
		for (int i=0; i<land.length; i++){
			for (int j=0; j<land[0].length; j++){
				int size = computeSize(land, i, j);
				if (size>0){
					pondSizes.add(size);
				}
			}
		}
		return pondSizes;
	}
	public static int computeSize(int[][] land, int row, int col){
		if(row<0||col<0||row>(land.length-1)||col>(land[0].length-1)||land[row][col]==-1||land[row][col]>0) return 0;
		land[row][col]=-1;
		int size = 1;
		size+=computeSize(land, row-1, col);
		size+=computeSize(land, row-1, col-1);
		size+=computeSize(land, row-1, col+1);
		size+=computeSize(land, row, col-1);
		size+=computeSize(land, row, col+1);
		size+=computeSize(land, row+1, col-1);
		size+=computeSize(land, row+1, col);
		size+=computeSize(land, row+1, col+1);
		return size;
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
		int[] arr = {2, -8, 3, -20, 0, 10};
		System.out.println(findMaxSum(arr));
		System.out.println(matchesPattern("catcatdogcat", "aaba"));
		int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
		ArrayList<Integer> pondSizes = computePondSizes(land);
		System.out.println(pondSizes.size());
		for (int i=0; i<pondSizes.size(); i++){
			System.out.print(pondSizes.get(i) + " ");
		}
	}
}