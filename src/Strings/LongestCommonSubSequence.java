package Strings;


/**
 * O(mn) solution - DP
 * @author sujen
 *
 */
public class LongestCommonSubSequence {
	
	public static void main(String[] args) {
		System.out.println(lcs("AGGTAB", "GXTXAYB"));
	}
	
	static int lcs(String s1, String s2){
		int[][] lcs = new int[s1.length()+1][s2.length()+1];
		
		for(int i=0;i<=s1.length();i++){
			for(int j=0; j<=s2.length();j++){
				if(i==0 | j==0 ){
					lcs[i][j]=0;
				}
				else if(s1.charAt(i-1) == s2.charAt(j-1)){
					lcs[i][j] = lcs[i-1][j-1]  + 1;
				}
				else
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
		return lcs[s1.length()][s2.length()];
	}
}
