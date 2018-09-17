package graph;

import java.util.List;

public class printPath {
	
	boolean printPath(char[][] grid, int r, int c, char target){
		if(r>=grid.length || r<0 || c<0 || c>=grid.length){
			return false;
		}
		if(grid[r][c]=='x'){
			return false;
		}else if(grid[r][c]==target){
			System.out.println(target);
			return true;
		}
		char val = grid[r][c];
		grid[r][c] = 'x';
		for(char child: getNeighbors(grid, r, c)){
			if(printPath(grid, r-1, c, target) || printPath(grid, r+1, c, target) || printPath(grid, r, c+1, target) || printPath(grid, r, c-1, target)){
				System.out.println(child);
				return true;
			}
		}
		grid[r][c] = val;
		return false;
	}

	private List<Character> getNeighbors(char[][] grid, int r, int c) {
		// TODO Auto-generated method stub
		return null;
	}

}
