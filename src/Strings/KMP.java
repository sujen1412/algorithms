package Strings;

public class KMP {
	
	static int[] prefixFunc;
	
	public static void main(String[] args) {
		
		String s = "abcabsdwer";
		String p = "absdwr";
		System.out.println(performKMP(s.toCharArray(), p.toCharArray()));
	}
	
	static int performKMP(char[] str, char[] pattern){
		int n = str.length;
		int m = pattern.length;
		prefixFunc = new int[m];
		prefixArray(pattern, m);
		int i=0,j=0;
		while(i<n){
			if(str[i]==pattern[j]){
				if(j==m-1){
					return i-j;
				}
				else{
					i++;j++;
				}
			}
			else if(j>0){
				j = prefixFunc[j-1];
				
			}
			else
				i++;
		}
		
		return -1;
	}
	
	static void prefixArray(char[] p, int m){
		int i=1,j=0;
		prefixFunc[0]=0;
		prefixFunc[1]=0;
		
		while(i<m){
			if(p[j]==p[i]){
				prefixFunc[i] = j+1;
				i++;j++;
			}
			else if(j>0){
				j = prefixFunc[j-1];
			}
			else{
				prefixFunc[i] = 0;
				i++;
			}
		}
	}
}
