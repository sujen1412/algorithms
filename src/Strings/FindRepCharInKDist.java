package Strings;

import java.util.LinkedHashMap;

public class FindRepCharInKDist {
	
	public static void main(String[] args) {
		findRep("abacasdasdasd", 3);
	}
	
	static void findRep(String s, int k){
		MyHash lru = new MyHash(k);
		char[] c = s.toCharArray();
		for(int i=0;i<c.length;i++){
			if(lru.containsKey(c[i])){
				System.out.println(c[i]);
			}
			lru.put(c[i], true);
		}
	}
	
}

class MyHash extends LinkedHashMap<Character, Boolean>{
	int k;
	public MyHash(int k){
		super(k, 1, true);
		this.k = k;		
	}
	
	protected boolean removeEldestEntry(
			java.util.Map.Entry<Character, Boolean> eldest) {
		// TODO Auto-generated method stub
		return size() > k;
	}
}
