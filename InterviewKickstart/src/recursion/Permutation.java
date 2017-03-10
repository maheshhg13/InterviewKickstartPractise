package recursion;

import java.util.Arrays;

public class Permutation {

	public static void main(String[] args){
		String data="abc";
		permute(data.toCharArray(), new char[data.length()], 0);
	}

	public static void permute(char[] data, char[] temp, int start){
		if(start>=data.length){
			System.out.println(new String(temp));
			return;
		}
		for(int i=0;i<data.length;i++){
			if(new String(temp).contains(data[i]+"")){
				continue;
			}
			temp[start] = data[i];
			permute(data, Arrays.copyOf(temp, temp.length), start+1);
		}
	}
}
