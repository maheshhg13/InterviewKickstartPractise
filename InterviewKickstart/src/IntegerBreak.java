import java.util.Arrays;

public class IntegerBreak {
	public static void main(String[] args) {
		int n = 6;
		int[] cache = new int[n+1];
		System.out.println(IntBreak(n, cache));
	}
	
	public static int IntBreak(int n, int[] cache){
		if(n<=3){
			return n;
		}
		if(cache[n]!=0){
			System.out.println("Got: "+n+" returning: "+cache[n]);
			return cache[n];
		}
		int result = Integer.MIN_VALUE;
		for(int i=1;i<=(n/2)+1;i++){
			int temp = IntBreak(n-i, cache);
			result = Math.max(result, i*temp);
		}
		cache[n] = result;
		System.out.println("Setting Got: "+n+" returning: "+cache[n]);
		return result;
	}

}
