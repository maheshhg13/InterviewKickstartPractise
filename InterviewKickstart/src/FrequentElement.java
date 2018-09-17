
public class FrequentElement {
	
	public int searchFirst(int[] arr, int start, int end, int target){
		while(end-start>1){
			int mid = (end-start)/2;
			if(arr[mid]<target){
				start = mid;
			}else{
				end = mid;
			}
		}
		return end;
	}
	
	public int searchLast(int[] arr, int start, int end, int target){
		while(end-start>1){
			int mid = (end-start)/2;
			if(arr[mid]<=target){
				start = mid;
			}else{
				end = mid;
			}
		}
		return start;
	}
	
	
	public int frequent(int[] arr, int pc){
		if(pc>100){
			throw new RuntimeException();
		}
		int width = arr.length/(100/pc);
		int[] indexes = new int[100/pc];
		for(int i=0;i<indexes.length;i++){
			indexes[i] = i*width;
		}
		for(int x:indexes){
			int start = searchFirst(arr, 0, arr.length, arr[x]);
			int end = searchLast(arr, 0, arr.length, arr[x]);
			if(end-start+1 >=width){
				return arr[x];
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,2,2,5,6,7,8,9,10};
		new FrequentElement().frequent(arr, 25);
	}
}
