package datastructures.arrays;

import java.util.Stack;

public class NextGreatestElement {

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] arr = {1,2,4,7,10,11,12,18,22,16,18,19};
		nextMax(arr);

	}

	static void nextMax(int[] a){
		Stack<Integer> elemStack = new Stack<Integer>();
		if(a.length==0){
			return;
		}
		if(a.length==1){
			System.out.println(-1);
		}
		else{
			int next, current;
			elemStack.push(a[0]);
			for(int i=1;i<a.length;i++){
				next = a[i];
				current = elemStack.pop();
				while(current<next){
					System.out.println(current+ " : " + next);
					if(elemStack.isEmpty() == false){
						current = elemStack.pop();
					}
					else{
						break;
					}
				}
				if(current>next){
					elemStack.push(current);
				}
				elemStack.push(next);
			}
		}
		while(elemStack.isEmpty()== false){
			System.out.println(elemStack.pop() + " : " + -1);
		}
	}
}
