package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestSubstringWithKCharacters {
	public static String SmallestSubstring(String orig, Set<Character> set){
		int start = 0;
		int k = set.size();
		String result = orig;
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<orig.length();i++){
			char current = orig.charAt(i);
			if(set.contains(current)){
				if(!map.containsKey(current)){
					map.put(current, 1);
				}else{
					map.put(current, map.get(current)+1);
				}
				if(map.size()==k){
					while(!set.contains(result.charAt(start)) || map.get(result.charAt(start))>1){
						if(map.containsKey(result.charAt(start)))
							map.put(result.charAt(start), map.get(result.charAt(start))-1);
						start++;
					}

					String temp = orig.substring(start, i+1);
					if(temp.length()<result.length()){
						result = temp;
						System.out.println("---  "+result);
					}
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Set<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('d');
		System.out.println(SmallestSubstring("mdbdacb", set));
	}
}
