package backtracking;

import java.util.HashSet;
import java.util.Set;

public class CompareOutputs {
	public static void main(String[] args) {
		String[] mo = {};
		String[] og = {};
		System.out.println("My Size: "+mo.length);
		System.out.println("Required Size: "+og.length);
		Set<String> my = new HashSet<String>();
		Set<String> o = new HashSet<String>();
		addToSet(my, mo);
		addToSet(o, og);
		System.out.println("Things that are extra in me: ");
		my.removeAll(o);
		System.out.println(my.size());
		for(String s: my){
			System.out.println(s);
		}
	}
	
	private static void addToSet(Set<String> set, String[] arr){
		for(String x:arr){
			set.add(x);
		}
	}
}
