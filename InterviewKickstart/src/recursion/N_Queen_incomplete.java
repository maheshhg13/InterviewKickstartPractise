package recursion;

public class N_Queen_incomplete {

	private static int placeQueen(boolean[][] mat, int col, int n) {
		if(col>=n){
			return 1;
		}
		int count = 0;
		for(int row=0;row<n;row++){
			if(canIplace(mat, row, col)){
				mat[row][col] = true;
				count += placeQueen(mat, col+1, n);
				mat[row][col] = false;
			}
		}
		return count;
	}

	private static boolean canIplace(boolean[][] mat, int row, int col) {
		for(int i=0;i<col;i++){
			if(mat[row][i])
				return false;
		}

		for(int i=row,j=col; i>=0 && j>=0; i--, j--){
			if(mat[row][i])
				return false;
		}
		
		
		
		return true;

	}

	public static void main(String[] args){

	}


}
