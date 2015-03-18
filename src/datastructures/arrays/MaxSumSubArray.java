package datastructures.arrays;

public class MaxSumSubArray {

	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, 1, -1};
		System.out.println(maxSum(arr));
	}
	
	private static int maxSum(int[] arr) {
		int max_so_far = arr[0], max_ending_here = arr[0];
		int i =1;
		int endIndex = 0;
		while(i<arr.length){
			max_ending_here = Math.max(arr[i], max_ending_here+arr[i]);
			
			int temp_max = Math.max(max_so_far, max_ending_here);
			if(max_so_far < temp_max){
				endIndex = i;
			}
			max_so_far = temp_max;
			i++;
		}
//		int temp_sum = max_so_far;
//		while(temp_sum>0){
//			System.out.print(arr[endIndex]);
//			temp_sum -= arr[endIndex];
//			endIndex--;
//		}
		return max_so_far;
	}
}
