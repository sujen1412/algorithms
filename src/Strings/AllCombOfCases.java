package Strings;

import java.util.HashSet;
import java.util.Set;

public class AllCombOfCases {

	static Set<String> set = new HashSet<String>();
	public static void main(String[] args) {
		printCombos("0abc", 0);
		System.out.println(set);
	}
	
	static void printCombos(String s, int index){
		set.add(s);
		
		for(int i = index ; i<s.length(); i++){
			String str = s.replace(s.charAt(i), Character.toUpperCase(s.charAt(i)));
			printCombos(str, i+1);
		}		
	}
}
