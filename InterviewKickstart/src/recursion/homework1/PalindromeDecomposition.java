package recursion.homework1;

import java.util.ArrayList;
import java.util.List;

public class PalindromeDecomposition {
	public static String[] palindromicDecomposition(String strInput) {
        List<String> result = new ArrayList<String>();
        List<String> partition = new ArrayList<String>();
        recurse(strInput, 0, partition, result);
        return result.toArray(new String[result.size()]);
    }

    public static void recurse(String s, int start, List<String> partition, List<String> result){
        if(start==s.length()){
            result.addAll(partition);
            return;
        }
        for(int i = start+1;i<=s.length();i++){
            String temp = s.substring(start, i);
            if(isPalindrome(temp)){
                partition.add(temp);
                recurse(s, i, partition, result);
                partition.remove(partition.size()-1);
            }
        }
    }

    static boolean isPalindrome(String strarr) {
        return recurse(strarr.toCharArray(), 0, strarr.length()-1);
    }

    static boolean recurse(char[] data, int a, int b){
        if(a==b || a>b){
            return true;
        }
        while(!Character.isAlphabetic(data[a]) && a<data.length){
    		a++;
    	}
    	while(!Character.isAlphabetic(data[b]) && b>0){
    		b--;
    	}
        if(a<data.length && b>=0 && Character.toLowerCase(data[a]) == Character.toLowerCase(data[b])){
            return recurse(data, a+1, b-1);
        }
        return false;
    }
    public static void main(String[] args) {
    	String strInput = "abracadabra";
		String[] temp = palindromicDecomposition(strInput);
		for(String s:temp){
			System.out.println(s);
		}
	}
}
