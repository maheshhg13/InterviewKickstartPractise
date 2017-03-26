package recursion;

public class ReverseRecursive {
	public static String reverse(String s){
		if(s.length()==0){
			return "";
		}
		String last = s.charAt(s.length()-1)+"";
		String reversed = reverse(s.substring(0, s.length()-1));
		return last+reversed;
	}
	public static void main(String[] args) {
		System.out.println(reverse("abc"));
	}
}

//number N, number K
//N = 1-1000
//K = 2-10
//
//Count the num of possible pairs, 