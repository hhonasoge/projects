import java.util.*;

public class SortingSearching{
	public static void bubbleSort(int arr[]){
		int length = arr.length;
		for (int i=0; i<length; i++){
			for (int j=1; j<(length-i);j++){
				if (arr[j]<arr[j-1]){
					swap(arr, j, j-1);
				}
			}
		}
		return;
	}
	public static void insertionSort(int arr[]){
		int length = arr.length;
		for (int i=1;i<length; i++){
			int key = arr[i];
			int j = i-1;
			while (j>-1 && arr[j]>key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	public static void selectionSort(int arr[]){
		for (int i=0; i<arr.length; i++){
			int index = i;
			for (int j = index; j<arr.length; j++){
				if (arr[j]<arr[index]){
					index = j;
				}
				int tmp = arr[i];
				arr[i] = arr[index];
				arr[index] = tmp;
			}
		}
	}
	public static void mergeSort(int arr[]){
		int[] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length-1);
	}
	public static void mergeSort(int[] arr, int[] helper, int low, int high){
		if (low>=high) return;
		int mid = (low+high)/2;
		mergeSort(arr, helper, low, mid);
		mergeSort(arr, helper, mid+1, high);
		merge(arr, helper, low, mid, high);
	}
	public static void merge(int[] arr, int[] helper, int low, int mid, int high){
		for (int i=0;i<arr.length;i++){
			helper[i] = arr[i];
		}
		int helperLeft = low;
		int helperRight = mid+1;
		int curr = low;
		while (helperLeft<=mid && helperRight <=high){
			if (helper[helperLeft]<=helper[helperRight]){
				arr[curr] = helper[helperLeft];
				helperLeft++;
			} else {
				arr[curr] = helper[helperRight];
				helperRight++;
			}
			curr++;
		}
		int remaining = mid - helperLeft;
		for (int i=0; i<=remaining;i++){
			arr[curr+i] = helper[helperLeft+i];
		}
	}
	public static void quickSort(int[] arr){
		quickSort(arr, 0, arr.length-1);
	}
	public static void quickSort(int[] arr, int low, int high){
		if (low>=high)return;
		int p = partition(arr, low, high);
		quickSort(arr, low, p-1);
		quickSort(arr, p+1, high);
	}
	public static int partition(int[] arr, int low, int high){
		int p, i, firsthigh;
		p = high;
		firsthigh = low;
		for (i=low; i<high; i++){
			if (arr[i]<arr[p]){
				swap(arr, i, firsthigh);
				firsthigh++;
			}
		}
		swap(arr, p, firsthigh);
		return firsthigh;
	}
	private static void swap(int[] arr, int index1, int index2){
		if (index1>=arr.length||index2>=arr.length||index1<0||index2<0){throw new IndexOutOfBoundsException("One of the indices is out of bounds");}
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
		return;
	}
	public static void main(String[] args){
		int[] testArr = {-1, 5, 3, 2, 9, 24, 11, 16, 7, 8};
		quickSort(testArr);
		for (int i=0; i<testArr.length; i++){
			System.out.print(testArr[i] + "    ");
		}
	}
}