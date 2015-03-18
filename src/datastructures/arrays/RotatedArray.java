package datastructures.arrays;

/**
 * Rotated SubArray Problem
 * @author sujen
 *
 */
public class RotatedArray {

	public static void main(String[] args) {
		int[] arr = {27,30,12,15,19,24};
		System.out.println(getPivot(arr, 0, arr.length-1));
		System.out.println(findKey(arr, 0, arr.length-1, 25));
	}
	
	private static int getPivot(int[] arr, int low, int high) {
		if(low>high){
			return -1;
		}
		if(low==high){
			return low;
		}
		int mid = (low + high)/2;
		if(arr[mid]>arr[low]){
			if(arr[mid]<arr[mid-1]){
				return mid-1;
			}
		}
		if(arr[mid]<arr[high]){
			if(arr[mid]>arr[mid+1]){
				return mid;
			}
		}
		if(arr[low]>arr[mid]){
			return getPivot(arr, low, mid-1);
		}
		else{
			return getPivot(arr, mid+1, high);
		}
	}
	
	//iterative approach
	public static int findKey(int[] arr, int low, int high, int key){
		
		while(low<=high){
			int mid = low + (high-low)/2;
			if(arr[mid] == key){
				return mid;
			}
			if(arr[low]<arr[mid]){
				if(key >= arr[low] && key < arr[mid]){
					high = mid -1;
				}
				else
					low = mid+1;
			}
			else{
				if(key > arr[mid] && key <= arr[high]){
					low = mid+1;
				}
				else
					high = mid -1;
			}
		}
		
		return -1;
		
	}
}