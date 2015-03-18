package datastructures.arrays;

public class MinIndicesToSortArray {
	public static void main(String[] args) {
		int[] arr = {1,2,4,7,10,11,7,12,18,6,7,22,16,18,19};
		findIndices(arr);
	}
	
	static void findIndices(int[] arr){
		int leftEnd=0, rightStart=arr.length-1;
		
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i+i]<arr[i]){
				leftEnd = i;
				System.out.println("leftEnd : " + leftEnd);
				break;
			}
		}
		for (int i = arr.length-2; i >= 0; i--) {
			if(arr[i]>arr[i+1]){
				rightStart = i+1;
				System.out.println("right : " + rightStart);
				break;
			}
		}
		int min = leftEnd+1;
		if(min>=arr.length){
			return;
		}
		int max = rightStart-1;
		for(int i= leftEnd; i<rightStart; i++){
			if(arr[i]<arr[min]){
				min = i;				
			}		
			if(arr[i]>arr[max])
				max=i;
		}
		System.out.println(arr[min] + " : " + arr[max]);
		int leftIndex = leftEnd, rightIndex = rightStart;
		for(int i=0;i<leftEnd;i++){
			if(arr[min]>arr[i]){
				leftIndex =i;
			}				 
		}
		for(int i=rightStart;i<arr.length;i++){
			if(arr[max]>arr[i]){
				rightIndex = i;
			}
		}
		System.out.println((leftIndex+1) + " : "  + rightIndex);
	}
}
