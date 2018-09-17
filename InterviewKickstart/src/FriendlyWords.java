import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendlyWords {
	static String[] friendlyWords(String[] input){
		if(input==null || input.length==0){
			return new String[0];
		}
		Arrays.sort(input);
		Map<String, String> map = new HashMap<String, String>();
		for(String str:input){
			str = str.trim().toLowerCase();
			String mashed = mash(str);
			if(!map.containsKey(mashed))
				map.put(mashed, "");
			map.put(mashed, (map.get(mashed)+" "+str).trim());
		}
		List<String> temp = new ArrayList<String>();
		for(String key:map.keySet()){
			String words = map.get(key);
			String[] split = words.split(" ");
			if(split.length>1){
				Arrays.sort(split);
				temp.add(words);
			}
		}
		String[] result = new String[temp.size()];
		for(int i=0;i<temp.size();i++){
			result[i] = temp.get(i);
		}
		Arrays.sort(result);
		return result;
	}
	
	static String mash(String temp){
		if(temp==null || temp.equals("")) return null;
		char[] input = temp.toCharArray();
		Arrays.sort(input);
		return new String(input);
	}
	
	public static void main(String[] args) {
		String[] input = {"car", "cheating", "dale", "deal", "lead", "listen", "silent", "teaching"};
		String[] result = friendlyWords(input);
		for(String x:result){
			System.out.println(x);
		}
	}
}
