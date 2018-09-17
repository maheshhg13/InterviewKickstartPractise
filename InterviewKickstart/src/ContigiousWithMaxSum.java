import java.util.ArrayList;
import java.util.List;

public class ContigiousWithMaxSum {
	public int[] max(int[] arr){
		int sum = arr[0];
		int maxSoFar = arr[0];
		int[] temp = {0, 0};
		int[] result = new int[2];
		for(int i=1;i<arr.length;i++){
			int x = arr[i];
			//maxSoFar = Math.max(maxSoFar+x, x);
			if(maxSoFar+x > x){
				maxSoFar+=x;
				temp[1] = i;
			}else{
				maxSoFar=x;
				temp = new int[]{i, i};
			}
			
			if(sum<maxSoFar){
				sum = maxSoFar;
				result[0] = temp[0];
				result[1] = temp[1];
			}
		}
		return result;
	}
	
	public int maxSubArray(int[] arr){
		int max = arr[0];
		int maxSoFar = arr[0];
		for(int i=1;i<arr.length;i++){
			int x = arr[i];
			maxSoFar = Math.max(maxSoFar+x, x);
			max = Math.max(maxSoFar, max);
		}
		return max;
	}
	public static void main(String[] args) {
		int[] arr = {1,3,-4,6,-2,10,12};
		int[] result = new ContigiousWithMaxSum().max(arr);
		for(int i=result[0]; i<=result[1];i++){
			System.out.print(arr[i]+", ");
		}
	}
}
