package Strings;

public class SimpleRegex {

	public static void main(String[] args) {
		
		String regex = "****a*c";
		String str = "abcc";
		System.out.println(match(regex, str));
	}
	
	static boolean match(String regex, String str){
		
		if(regex.length() ==0 && str.length() == 0){
			return true;
		}
		if(str.length() == 0){
			return false;
		}
		if(regex.length() == 0){
			return false;
		}
		if(regex.charAt(0) =='.'){
			return match(regex.substring(1), str.substring(1));
		}
		
		if(regex.charAt(0) == '*'){
			return match(regex.substring(1), str) || match(regex, str.substring(1));
		}
		
		if(regex.charAt(0) == str.charAt(0)){
			return match(regex.substring(1), str.substring(1));
		}
		
		return false;
	}
}
