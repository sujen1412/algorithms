package Strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKWords {

	public static void main(String[] args) {
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		counts.put("hello", 10);
		counts.put("world", 9);
		counts.put("hi", 11);
		counts.put("how", 14);
		counts.put("are", 05);
		counts.put("now", 106);
		counts.put("you", 1);
		
		for(Word w: getTopK(counts, 4)){
			System.out.println(w.word + " : " + w.count);
		}
		
	}
	
	static PriorityQueue<Word> getTopK(HashMap<String, Integer> counts, int k){
		
		Comparator<Word> wordcmp = new Comparator<Word>(){
			public int compare(Word w1, Word w2){
				if(w1.count<w2.count){
					return -1;
				}
				else
					return 1;
			}
		};
		PriorityQueue<Word> minHeap = new PriorityQueue<Word>(1, wordcmp);
		
		for(Map.Entry<String, Integer> entry:counts.entrySet()){
			Word w = new Word(entry.getKey(), entry.getValue());
			if(minHeap.size()==k){
				minHeap.poll();
				minHeap.add(w);
			}
			else{
				minHeap.add(w);
			}
		}
		
		return minHeap;
	}
}

class Word{
	String word;
	int count;
	

	public Word(String key, Integer value) {
		// TODO Auto-generated constructor stub
		word = key;
		count = value;
	}
}