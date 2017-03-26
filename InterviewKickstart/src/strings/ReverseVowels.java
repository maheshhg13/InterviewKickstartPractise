package strings;

public class ReverseVowels {
	public static String reverse(String str){
		char[] arr = str.toCharArray();
		int l = 0;
		int h = arr.length-1;
		while(l<h){
			while(l<h && !isVowel(arr[l])){
				l++;
			}
			
			while(l<h && !isVowel(arr[h])){
				h--;
			}
			
			//if(l<h){
				char temp = arr[l];
				arr[l] = arr[h];
				arr[h] = temp;
				l++;
				h--;
			//}
		}
		return new String(arr);
	}
	
	public static boolean isVowel(char a){
		if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("united"));
	}
}
