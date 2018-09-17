import java.util.Random;

public class GFunction {
	public int g3(){
		int[] arr = {1,2,3};
		Random rand = new Random();
		return arr[rand.nextInt(arr.length)];
	}
	
	public int g7(){
		int[] arr = {1,2,3,4,5,6,7};
		Random rand = new Random();
		return arr[rand.nextInt(arr.length)];
	}
	
	public int g20(){
		int[][] arr = {{1,2,3,4,5,6,7},{8,9,10,11,12,13,14},{15,16,17,18,19,20,21}};
		return 0;
	}
}
