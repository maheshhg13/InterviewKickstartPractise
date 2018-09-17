import java.util.Random;

public class ShuffleArray {
	
	public void shuffle(int[] arr){
		Random r = new Random();
		for(int i=arr.length-1;i>0;i--){
			int rand = r.nextInt(i);
			int temp = arr[rand];
			arr[rand] = arr[i];
			arr[i] = temp;
			
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		for(int x:arr){
			System.out.print(x+", ");
		}
		System.out.println();
		new ShuffleArray().shuffle(arr);
		for(int x:arr){
			System.out.print(x+", ");
		}
	}
	

}
