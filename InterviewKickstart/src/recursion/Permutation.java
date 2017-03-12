package recursion;

public class Permutation {

	public static void main(String[] args){
		String data="5279";
		permute(data.toCharArray(), 0);
	}

	public static void permute(char[] data, int start){
		if(start==data.length){
			System.out.println(new String(data));
			return;
		}
		for(int i=start;i<data.length;i++){
			swap(data, i, start);
			permute(data, start+1);
			swap(data, i, start);
		}
	}
	
	private static void swap(char[] arr, int i, int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
