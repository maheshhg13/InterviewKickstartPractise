package backtracking;

import java.util.HashMap;
import java.util.Map;

public class WordPatternII {
	    public boolean wordPatternMatch(String pattern, String str) {
	        return recurse(pattern, str, new HashMap<Character, String>());
	    }
	    
	    private boolean recurse(String pattern, String str, Map<Character, String> map){
	        if(pattern.length()==0 && str.length()==0){
	            return true;
	        }else if(pattern.length()==0 || str.length()==0){
	            return false;
	        }else if(map.containsKey(pattern.charAt(0))){
	            if(str.startsWith(map.get(pattern.charAt(0)))){
	                return recurse(pattern.substring(1), str.substring(map.get(pattern.charAt(0)).length()), map);
	            }
	            return false;
	        }else{
	            String temp = "";
	            for(int i=0;i<str.length();i++){
	                temp = temp + str.charAt(i);
	                if(map.values().contains(temp)){
	                    continue;
	                }
	                map.put(pattern.charAt(0), temp);
	                if(recurse(pattern.substring(1), str.substring(i+1), map)){
	                    return true;
	                }
	            }
	            map.remove(pattern.charAt(0));
	            return false;
	        }
	    }
	    public static void main(String[] args) {
			System.out.println(new WordPatternII().wordPatternMatch("abba", "dogcatcatdog"));
		}
}
