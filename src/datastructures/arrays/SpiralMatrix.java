package datastructures.arrays;

import java.util.LinkedList;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] arr = { {1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}};
		System.out.println(getSpiral(arr).toString());
	}
	
	private static LinkedList<Integer> getSpiral(int[][] arr) {
		int m = arr[0].length;
		int n = arr.length;
		int x=0,y=0;
		LinkedList<Integer> spiral = new LinkedList();
		while(m>0 && n>0){
			if(m==1){
				for(int i=0;i<n-1;i++){
					spiral.add(arr[x][y]);
					x++;
				}
				break;
			}
			if(n==1){
				for(int i=0;i<m-1;i++){
					spiral.add(arr[x][y]);
					y++;
				}
				break;
			}
			for(int i=0;i<m-1;i++){
				spiral.add(arr[x][y]);
				y++;
			}
			for(int i=0;i<n-1;i++){
				spiral.add(arr[x][y]);
				x++;
			}
			for(int i=0;i<m-1;i++){
				spiral.add(arr[x][y]);
				y--;
			}
			for(int i=0;i<n-1;i++){
				spiral.add(arr[x][y]);
				x--;				
			}
			x++;y++;
			m -=2;
			n -=2;
		}
		return spiral;
	}

}
