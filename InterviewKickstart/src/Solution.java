import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
public class Solution{
	public int totalScore(String[] blocks, int n){
		if(blocks==null || blocks.length==0){
			return 0;
		}
		List<Integer> lst = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			String current = blocks[i];
			if(isDigit(current)){
				lst.add(Integer.parseInt(current));
			}else if(current.equals("X")){
				int last = lst.get(lst.size()-1);
				lst.add(last*2);
			}else if(current.equals("+")){
				int a = lst.get(lst.size()-1);
				int b = lst.get(lst.size()-2);
				lst.add(a+b);
			}else if(current.equals("Z")){
				lst.remove(lst.size()-1);
			}
		}
		return sum(lst);
	}
	
	private boolean isDigit(String str){
		System.out.println("Got: "+str);
		for(int i=0;i<str.length();i++){
			char curr = str.charAt(i);
			
			if(curr!='-' && !Character.isDigit(curr)){
				System.out.println("Sending false");
				return false;
			}
		}
		System.out.println("Sending true");
		return true;
	}
	
	private int sum(List<Integer> lst){
		int total = 0;
		for(int x:lst){
			//System.out.println("Adding "+x);
			total+=x;
		}
		return total;
	}
	
	static long recurse(long k, long x, long[] cache){
		if(x==0){
			return 1;
		}else if(x<0){
			return 0;
		}else if(cache[(int)x]!=0){
			return cache[(int)x];
		}
		long result = 0;
		for(long i=1;i<=k;i++){
			if(i>x){
				break;
			}
			result+=recurse(k, x-i, cache);
		}
		cache[(int)x] = (long) (result%(Math.pow(10, 9)+7));
		return result;
	}
	
	static long solve(long k, long x){
		if(k<=0 || x<=0){
			return 0;
		}else if(k>x){
			return 1;
		}
		
		long[] cache = new long[(int)x+1];
		cache[0] = 1; cache[1] = 1;
		for(int i=2;i<=(int)x;i++){
			//cache[i] = 0;
			for(int j=1;j<=(int)k && j<=i;j++){
				cache[i]+=cache[i-j];
			}
		}
		
		//long result = recurse(k, x, new long[(int)(x+1)]);
		return (long) (cache[cache.length-1]%(Math.pow(10, 9)+7));
	}
	
	public static void helperHash(char[] possible, int i, char[] temp, Set<String> result){
		if(i==3){
			result.add(new String(temp));
			return;
		}
		
		for(char c : possible)
		{
			temp[i] = c;
			helperHash(possible, i+1, temp, result);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Set<String> result = new HashSet<String>();
		//String possibleStr = "0123456789abcdefghijklmnopqrstuvwxyz#";
		String possibleStr = "#abc";
		char[] possible = possibleStr.toCharArray();
		helperHash(possible, 0, new char[3], result);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(String x:result){
			min = Math.min(x.hashCode(), min);
			max = Math.max(x.hashCode(), max);

		}
		System.out.println("Count: "+result.size()+" Min: "+min+" Max: "+max+" Range: "+(max-min));
		
		//String[] blocks = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
		//System.out.println(new Solution().totalScore(blocks, 8));
		//long k=100;
		//long x=10000;
		//System.out.println(solve(k, x));
		String path = "/Users/Mahesh/Desktop/transfers.txt";
		List<String> lines = Files.readAllLines(Paths.get(path));
		int total = 0;
		for (String line : lines) {
			if(!line.contains("received")){
				continue;
			}
			String[] parts = line.split("received");
			StringBuilder sb = new StringBuilder(parts[0]);
			String amount = sb.deleteCharAt(0).deleteCharAt(1).toString();
			try{
			total+=Double.parseDouble(amount);
			}catch(Exception e){
				System.out.println(amount+" "+e.getMessage());
			}
		}
		HashSet<String> set = new HashSet<>();
		set.removeIf(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.startsWith("a");
			}
			
		});
		System.out.println(total);
	}
}