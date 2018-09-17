package dp;

import java.util.Arrays;

public class edit_distance {
	public int recurse_edit(char[] a, char[] b, int m, int n, int[][] mat){
		if(m==0){
			return n;
		}else if(n==0){
			return m;
		}else if(mat[m][n]!=-1){
			return mat[m][n];
		}else if(a[m-1]==b[n-1]){
			mat[m][n]= recurse_edit(a, b, m-1, n-1, mat);
		}else{
			mat[m][n]= 1+Math.min(recurse_edit(a, b, m-1, n, mat), Math.min(recurse_edit(a, b, m, n-1, mat), recurse_edit(a, b, m-1, n-1, mat)));
		}
		return mat[m][n];
	}
	public int distance(String a, String b){
		int[][] mat = new int[a.length()+1][b.length()+1];
		for(int i=0;i<mat.length;i++){
			Arrays.fill(mat[i], -1);
		}
		return recurse_edit(a.toCharArray(), b.toCharArray(), a.length(), b.length(), mat);
	}
	public static void main(String[] args) {
		System.out.println(new edit_distance().distance("cata", "mat"));
	}
}
