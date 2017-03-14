package warmup.test;

public class PalindromeRecursive {
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
    public static void main(String[] args){
    	System.out.println(isPalindrome("Red roses run no risk, sir, on nurses order."));
    }

}
