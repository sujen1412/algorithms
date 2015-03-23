package datastructures.hashmaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ThreadsRunningAtATime {
	public static void main(String [] args){
		LinkedList<Thread> listOfThreads = new LinkedList<Thread>();
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		for(int i = 0; i<num; i++){
			String[] line = sc.nextLine().split(" ");
			listOfThreads.add(new Thread(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
		}
		System.out.print("Enter time : " );
		int time = Integer.parseInt(sc.nextLine());
		System.out.print("count for given time is : " + getRunningThreads(time, listOfThreads));
	}
	
	static int getRunningThreads(int time, LinkedList<Thread> threads){
		int count = 0;
		HashMap<Integer, LinkedList<Thread>> tableOfThreads = new HashMap<Integer, LinkedList<Thread>>();
		for(Thread t: threads){
			for(int i=t.startTime;i<=t.endTime;i++){
				if(tableOfThreads.containsKey(i)){
					tableOfThreads.get(i).add(t);
				}
				else{
					LinkedList<Thread> listOfThreads = new LinkedList<Thread>();
					listOfThreads.add(t);
					tableOfThreads.put(i, listOfThreads);
				}
			}		
		}
		if(tableOfThreads.containsKey(time)){
			count = tableOfThreads.get(time).size();
		}
		return count;
	}
}

class Thread {
	int startTime;
	int endTime;
	
	public Thread(int startTime, int endTime){
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
