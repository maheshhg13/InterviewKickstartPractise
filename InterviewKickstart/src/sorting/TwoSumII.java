package sorting;

//Two Sum II - Input array is sorted
//
//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
//You may assume that each input would have exactly one solution and you may not use the same element twice.
//
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2

public class TwoSumII {

	public int[] twoSum(int[] numbers, int target){
		
		if(numbers.length==0){
			return new int[]{-1, -1};
		}
		int high = numbers.length-1;
		int low = 0;
		while(low<high){
			int sum = numbers[high] + numbers[low];
			if(sum==target){
				return new int[]{low+1, high+1};
			}else if(sum >target){
				high--;
			}else{
				low++;
			}
		}
		return new int[]{-1, -1};
	}
	
	public static void main(String[] args) {
		int[] input = {2, 7, 11, 15};
		int target = 9;
		int[] data = new TwoSumII().twoSum(input, target);
		System.out.println(data[0]+" "+data[1]);
	}

}
