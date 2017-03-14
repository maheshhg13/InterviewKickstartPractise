package sorting;

public class QuickSortPartition {
	public static int position(int[] data){
		int x = data[0];
		int i = 0;
		for(int m = 0;m<data.length;m++){
			if(data[m]<x){
				int temp = data[i];
				data[i] = data[m];
				data[m] = temp;
				i++;
			}
		}
		return i;
	}
	public static void main(String[] args) {
		System.out.println(position(new int[]{5, 1, 2, 10}));
	}
}
