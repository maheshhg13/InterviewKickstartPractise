import java.util.*;

public class IPAddress {
	public static List<String> IPCombinations(int input) {
        List<String> result = new ArrayList<String>();
        String s = Integer.toString(input);
        if(s.length()<4 || s.length()>12){
            return result;
        }
        recurse(s, "", 0, result);
        return result;
    }
    
    private static void recurse(String s, String temp, int start, List<String> result){
        if(temp.length()==s.length()+4){
            if(start==s.length())
                result.add(temp.substring(0, temp.length()-1));
        }else{
            for(int i=1;i<=3;i++){
                if(start+i>s.length()){
                    continue;
                }
                String part = s.substring(start, start+i);
                if(validate(part)){
                    recurse(s, temp+part+'.', start+i, result);
                }
            }
        }
    }
    
    private static boolean validate(String ip){
        if(ip.charAt(0)=='0'){
            return ip.equals("0");
        }
        int temp = Integer.parseInt(ip);
        return temp>=0 && temp<256;
    }
    
    public static void main(String[] args) {
		List<String> result = IPCombinations(12345);
		System.out.println(result);
		StringBuffer sb = new StringBuffer();
		//sb.setCharAt(sb.l, ch);
	}
}
