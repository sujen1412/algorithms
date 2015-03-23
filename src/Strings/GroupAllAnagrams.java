package Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * You have an array with words. Print them by anagrams groups 
 * Input = ["bat", "code", "cat", "tab", "cab", "crazy", "act","cat","dog","act"]
 * @author Sujen
 *
 */
public class GroupAllAnagrams {
	public static void main(String[] args) {
		String[] words = {"bat", "code", "cat", "tab", "cab", "crazy", "act","cat","dog","act"};
		Iterator it = groupByAnagram(words).entrySet().iterator();
		while(it.hasNext()){
			Map.Entry e = (Map.Entry) it.next();
			System.out.println(e.getValue());
		}
	}
	
	private static HashMap<String, List<String>> groupByAnagram(String[] words) {
		HashMap<String, List<String>> groupedAnagrams = new HashMap<String, List<String>>();
		for(String s:words) {
			String key = getKey(s);
			if(groupedAnagrams.containsKey(key)){
				groupedAnagrams.get(key).add(s);
			}
			else{
				List<String> anagramList = new LinkedList<String>();
				anagramList.add(s);
				groupedAnagrams.put(key.toString(), anagramList);
			}
		}
		return groupedAnagrams;
	}
	
	private static String getKey(String s){
		int[] asciiCounts = new int[256];
		for(int i=0;i<s.length();i++){
			int ascii = (int) s.charAt(i);
			asciiCounts[ascii]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<asciiCounts.length;i++){
			if(asciiCounts[i]>0){
				sb.append((char)i);
				sb.append(asciiCounts[i]);
			}
		}
		return String.valueOf(sb);
	}
	//Assuming the string has chars of ASCII range 0-255 (if this then sorting can be implemented in O(m) time.
	private static String sort(String s) {
		int[] asciiCounts = new int[256];
		for(int i=0;i<s.length();i++){
			int ascii = (int) s.charAt(i);
			asciiCounts[ascii]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<asciiCounts.length;i++){
			while(asciiCounts[i]>0){
				sb.append((char)i);
				asciiCounts[i]--;
			}
		}
		return sb.toString();
	}
}
