package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//n * k * log(k)
public class AnagramList {
	
	public List<List<String>> getAnagrams(List<String> data){
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String s : data){
			String temp = scramble(s);
			System.out.println(temp);
			if(!map.containsKey(temp)){
				map.put(temp, new ArrayList<>());
			}
			map.get(temp).add(s);
		}
		List<List<String>> result =  new ArrayList<List<String>>();
		for(List<String> x: map.values()){
			result.add(x);
		}
		return result;
	}
	
	private String scramble(String str){
		char[] arr = new char[26];
        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-'a']++;
        }
		return new String(arr);
	}
	
	public static void main(String[] args) {
		List<String> temp = new ArrayList<String>();
		temp.add("aba");
		temp.add("aab");
		temp.add("mahesh");
		List<List<String>> result = new AnagramList().getAnagrams(temp);
		for(List<String> s: result){
			for(String x:s){
				System.out.print(x+" ");
			}
		System.out.println("");
		}
	}

}
