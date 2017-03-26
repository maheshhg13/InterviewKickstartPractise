package recursion.homework1;
import java.io.*;
import java.util.*;
public class WildCard {
	public static void recurse(char[] input, int start, List<String> result){
        if(start==input.length){
            result.add(new String(input));
        }else{
            if(input[start]=='?'){
                input[start] = '1';
                recurse(input, start+1, result);
                input[start] = '0';
                recurse(input, start+1, result);
                input[start] = '?';
            }else{
                recurse(input, start+1, result);
            }
        }
    }
    public static void main(String args[] ) throws Exception {
        List<String> result = new ArrayList<String>();
        //BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        //String temp = rd.readLine();
        String temp = "??0?";
        recurse(temp.toCharArray(), 0, result);
        for(String x:result){
            System.out.println(x);
        }
    }

}
