package recursion;

import java.util.Set;

public class Subset_incomplete {

	public static void main(String[] args){
		String s = "3257";
		subset(s.toCharArray(), 0, new char[s.length()], 0);
		
	}
	public static void subset(char[] s, int read, char[] c, int write){
		if(read==s.length){
			System.out.println(new String(c,0, write));
			return;
		}
		subset(s, read+1, c, write);
		c[write] = s[read];
		subset(s, read+1, c, write+1);
		
	}
}
