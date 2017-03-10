package recursion;
//
//
//
public class MatrixMaxPath {

	public int fixPath(int[][] matrix){
		return recurse(matrix, 0, 0);
	}
	
	public int recurse(int[][] mat, int x, int y){
		if(x==mat.length-1 && y==mat[0].length-1){
			return mat[x][y];
		}else if(x==mat.length){
			return mat[x][y] + recurse(mat, x, y+1);
		}else if(y==mat[0].length-1){
			return mat[x][y] + recurse(mat, x+1, y);
		}else{
			return mat[x][y]+=Math.max(recurse(mat, x+1, y), recurse(mat, x, y+1));
		}
	}
}
