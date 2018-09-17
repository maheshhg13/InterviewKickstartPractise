package backtracking;
import java.util.*;

public class GeneralizedAbbrevation {
	public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        if(word==null || word.length()==0){
            result.add("");
            return result;
        }    
        Queue<String> q = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        q.add(word);
        set.add(word);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                String current = q.poll();
                List<String> children = getNext(current);
                for(String child:children){
                    if(set.add(child)){
                        q.add(child);
                    }
                }
            }
        }
        //result.add(word);
        result.addAll(set);
        //Collections.sort(result);
        return result;
    }
    
    private List<String> getNext(String word){
        List<String> result = new ArrayList<String>();
        char[] arr = word.toCharArray();
        for(int i=0;i<word.length();i++){
            if(!Character.isDigit(arr[i])){
                char ch = arr[i];
                arr[i] = '1';
                String temp = new String(arr);
                if(temp.equals("101")){
                    System.out.println(word);
                }
                result.add(parse(temp));
                arr[i] = ch;
            }
        }
        return result;
    }
    
    private String parse(String word){
        char[] chars = word.toCharArray();
        String result = "";
        int count=0;
        for(int i=0;i<chars.length;i++){
            if(Character.isDigit(chars[i])){
                count = count*10+chars[i]-'0';
                continue;
            }
            if(count>0){
                result+=count+"";
                count = 0;
            }
            result+=chars[i]+"";
        }
        if(count>0){
            result+=count+"";
        }
        //if(result.equals("2")){
        //    System.out.println(word);
        //}
        return result;
    }
    public static void main(String[] args) {
		List<String> result = new GeneralizedAbbrevation().generateAbbreviations("interaction");
		System.out.println(result.size());
	}
}
