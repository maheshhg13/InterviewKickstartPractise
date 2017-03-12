package warmup.test;

public class PalindromeRecursive {
	static boolean isPalindrome(String strarr) {
		strarr = strarr.trim();
		strarr = strarr.toLowerCase();
		String newStr = "";
		for(int i=0;i<strarr.length();i++){
			if(Character.isAlphabetic(strarr.charAt(i))){
				newStr = newStr+strarr.charAt(i);
			}
		}
        return recurse(newStr.toCharArray(), 0, strarr.length()-1);
    }

    static boolean recurse(char[] data, int a, int b){
        if(a==b || a>b){
            return true;
        }
        if(data[a]==data[b]){
            return recurse(data, a+1, b-1);
        }
        return false;
    }
    public static void main(String[] args){
    	System.out.println(isPalindrome("Red roses run no risk, sir, on nurses order."));
    }

}
