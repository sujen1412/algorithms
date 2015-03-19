package datastructures.arrays;

import java.util.Arrays;

public class QuickSelect {

	public static void main(String[] args) {
		int[] arr = {1,2,4,7,10,11,12,18,6,22,16,18,19};
		System.out.println(quickSelect(arr, 0, arr.length-1, arr.length - -1 - 2));
		//Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static int quickSelect(int[] arr, int low, int high, int n){
		if(low == high){
			return arr[low];
		}
		int pivotIndex = (low+high)/2;
		pivotIndex = partition(arr, low, high, pivotIndex);
		if(pivotIndex == n){
			return arr[n];
		}
		else{
			if(pivotIndex<n){
				return quickSelect(arr, pivotIndex +1,high , n);
			}
			else
				return quickSelect(arr, low, pivotIndex-1, n);
		}
		
	}
	
	static int partition(int[] a, int low, int high, int pivotIndex){
		int pivotValue = a[pivotIndex];
		swap(a, pivotIndex, high);
		int index = low;
		for(int i=low;i<high-1;i++){
			if(a[i]<pivotValue){
				swap(a, index, i);
				index++;
			}
		}
		swap(a, index, high);
		return index;
		
	}
	
	static void swap(int[] a, int a1, int a2){
		int temp = a[a1];
		a[a1] = a[a2];
		a[a2] = temp;
	}
}
