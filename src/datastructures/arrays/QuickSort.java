package datastructures.arrays;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {1,2,4,7,10,11,7,12,18,6,7,22,16,18,19};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int low, int high){
		if(low > high){
			return ;
		}
		int pivotIndex = (low+high)/2;
		pivotIndex = partition(arr, low, high, pivotIndex);

		quickSort(arr, pivotIndex +1,high);
		quickSort(arr, low, pivotIndex-1);
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
