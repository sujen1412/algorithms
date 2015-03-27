package datastructures.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianOfStreamingIntegers {

	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
		public int compare(Integer a, Integer b){
			if(a>b)
				return -1;
			else
				return 1;
		}
	});
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
		public int compare(Integer a, Integer b){
			if(a>b)
				return 1;
			else
				return -1;
		}
	});
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = Integer.parseInt(sc.nextLine());
		int n2 = Integer.parseInt(sc.nextLine());
		if(n1>n2){
			minHeap.add(n1);
			maxHeap.add(n2);
		}
		else{
			minHeap.add(n2);
			maxHeap.add(n1);
		}
			
		while(true){
			
			int num = Integer.parseInt(sc.nextLine());
			if(num<0)
				break;
			insert(num);
			System.out.println("MEdian : " + getMedian());
		}
		System.out.println("MEdian : " + getMedian());
	}
	
	private static void insert(int n){
		int getMax = maxHeap.peek();
		if(n<getMax)
			maxHeap.add(n);
		else
			minHeap.add(n);
		balance();
	}
	
	private static void balance() {
		if(maxHeap.size()>minHeap.size() + 1){
			minHeap.add(maxHeap.poll());
		}
		else if(minHeap.size()>maxHeap.size() + 1){
			maxHeap.add(minHeap.poll());
		}		
	}

	private static int getMedian(){
		if(minHeap.size()==maxHeap.size()){
			return (minHeap.peek() + maxHeap.peek())/2;
		} else if(maxHeap.size()>minHeap.size()){
			return maxHeap.peek();
		}
		else
			return minHeap.peek();
	}
}
