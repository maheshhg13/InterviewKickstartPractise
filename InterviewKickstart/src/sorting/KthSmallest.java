package sorting;

public class KthSmallest {
	public static int kthElement(int[] data, int k, int start, int end){
		int pivot = data[start];
		int i = start;
		int j =end;
		while(i<j){
			while(data[i]<pivot && i<j){
				i++;
			}
			while(data[j]>pivot && i<j){
				j--;
			}
			swap(data, i, j);
		}
		if(k-1==i){
			return pivot;
		}else if(k-1<i){
			return kthElement(data, k, start, i-1);
		}else{
			return kthElement(data, k, i+1, end);
		}
	}
	
	public static void swap(int[] data, int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] data  = {5, 4, 7, 2, 1, 9, 3, 6, 10, 8};
		int k = 3;
		System.out.println(kthElement(data, k, 0, data.length-1));
	}
}
