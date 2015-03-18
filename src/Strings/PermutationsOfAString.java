package Strings;

public class PermutationsOfAString {
	public static void main(String[] args) {
		String s = "ab";
		permute("",s);
	}
	
	private static void permute(String prefix, String s){
		if(s.length() == 0){
			System.out.println(prefix);
		}
		else{
			for(int i=0;i<s.length();i++){
				permute(prefix+s.charAt(i), s.substring(0, i) + s.substring(i+1, s.length()));
			}
		}
	}
}
