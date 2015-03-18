package datastructures.arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(LIS(arr));
	}
	
	private static int LIS(int[] arr){
		int max =1;
		int[] lis = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			lis[i] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && lis[i]<lis[j]+1){
					lis[i] = lis[j]+1;
				}
			}
		}
		for (int i = 0; i < lis.length; i++) {
			if(lis[i]>max)
				max=lis[i];
		}
		return max;
	}
}
