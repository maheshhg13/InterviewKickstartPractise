package sorting.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	static String[] printTriplets(int[] arr) {
        Arrays.sort(arr);
        List<String> result = new ArrayList<String>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int a = arr[i];
                int b = arr[j];
                int m = j+1;
                while(m<arr.length){
                    int c = arr[m];
                    int sum = a+b+c;
                    if(sum==0){
                        result.add(a+","+b+","+c);
                    }
                    m++;
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
	
	public static void main(String[] args){
		int[] input = {6, 10, 3, -4, 1, -6, 9};
		String[] result = printTriplets(input);
		for(String x: result){
			System.out.println(x);
		}
		
	}
}
