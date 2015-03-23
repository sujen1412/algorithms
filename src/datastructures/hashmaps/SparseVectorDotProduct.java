package datastructures.hashmaps;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given two sparse Vectors, compute the Dot Product.
Input Format : The first line will contain two numbers(k and n), 
which are the number of entries for the two vectors respectively.
The next k lines are the entries for the first vector, of the form : x y
where x is the position and y is the value at that position in the vector.
The n lines are the entries of the second vector.
Any entries not specified indicate zero at that position.
The two vectors will always be of the same length

Example input:
3 3
1 4
4 2
5 3
1 7
2 6
5 1

Sample Answer: Dot Product = 4*7+3*1 = 31 (only print 31)  
 * @author sujen
 *
 */
public class SparseVectorDotProduct {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] kn = sc.nextLine().split(" ");
		int k = Integer.parseInt(kn[0]);
		int n = Integer.parseInt(kn[1]);
		int sum = 0;
		HashMap<Integer, Integer> vectors = new HashMap<Integer, Integer>();
		
		for(int i=0;i<k;i++){
			String[] line = sc.nextLine().split(" ");
			vectors.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
		}
		
		for(int i=0;i<n;i++){
			String[] line = sc.nextLine().split(" ");
			int pos = Integer.parseInt((line[0]));
			if(vectors.containsKey(pos)){
				int value = Integer.parseInt(line[1]);
				sum += value*vectors.get(pos);
			}			
		}
		System.out.println("Dot product : " + sum);
	}
	
}
