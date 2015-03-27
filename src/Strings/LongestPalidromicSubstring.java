package Strings;

/**
 * Following is an O(n^2) time and O(1) space solution
 * @author sujen
 *
 */
public class LongestPalidromicSubstring {

	public static void main(String[] args) {
		
		getLPS("forgeeksskeegfor");
	}
	
	static void getLPS(String s){
		int start = 0;
		int low,high;
		int maxlength = 0;
		//for even length
		for(int i=1;i<s.length();i++){
			low = i-1;
			high = i;
			while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
				if(high-low+1>maxlength){
					start = low;
					maxlength = high - low +1;
					
				}
				low--;
				high++;
			}					
		}
		
		//for odd length
		for(int i=0;i<s.length();i++){
			low = i;
			high = i;
			while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
				if(high-low+1>maxlength){
					start = low;
					maxlength = high - low +1;	
				
				}
				low--;
				high++;
			}
		}
		
		System.out.println(s.substring(start, start + maxlength));
	}
}
