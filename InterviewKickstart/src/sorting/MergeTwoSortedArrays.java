
package sorting;

public class MergeTwoSortedArrays {
	public int[] merge(int[] a, int[] b){
		int[] result = new int[a.length+b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<a.length && j<b.length){
			if(a[i] < b[j]){
				result[k] = a[i];
				i++;
				k++;
			}else if(b[j] < a[i]){
				result[k] = b[j];
				j++;
				k++;
			}else{
				result[k] = a[i];
				i++;
				j++;
				k++;
			}
		}
		while(i<a.length){
			result[k] = a[i];
			i++;
			k++;
		}
		while(j<b.length){
			result[k] = b[j];
			j++;
			k++;
		}
		return result;
	}

}
