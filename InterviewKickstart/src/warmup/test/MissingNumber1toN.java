package warmup.test;

public class MissingNumber1toN {
	public static int missing(int[] numbers){
		int a = 0;
		for(int i=1;i<=numbers.length+1;i++){
			a = a ^ i;
		}
		int b = 0;
		for(int x:numbers){
			b = b^x;
		}
		return a^b;
	}
	public static void main(String[] args){
		System.out.println(missing(new int[]{2, 4, 1, 5}));
	}
}