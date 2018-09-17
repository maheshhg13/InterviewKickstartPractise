
public class TheMaze {

	public static void main(String[] args) {
		int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start = new int[]{0,4};
		int[] destination = new int[]{1,2};
		System.out.println(new TheMaze().hasPath(maze, start, destination));
	}
	int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		
		for(int i=0;i<directions.length;i++){
			if(helper(maze, start[0], start[1], destination, i)){
				return true;
			}
		}
        return false;
    }
	public boolean helper(int[][] maze, int x, int y, int[] destination, int direction){
		
		if(x<0 || x>=maze.length || y<0 || y>=maze[0].length || maze[x][y]!=0){
			return false;
		}
		//System.out.println("Visiting: "+x+" "+y+" Direction: "+direction);
		
		if(x==destination[0] && y==destination[1]){
			if(IsTouchingWallInDirection(x, y, maze, direction))
				return true;
		}
		
		if(IsTouchingWallInDirection(x, y, maze, direction)){
            maze[x][y] = -1;
			for(int i=0;i<directions.length;i++){
                if(directions[i][0]==-directions[direction][0] || directions[i][1]==-directions[direction][1])
                    continue;
				int[] coordinates = GetCoordinates(x, y, i);
				if(helper(maze, coordinates[0], coordinates[1], destination, i)){
					return true;
				}
			}
			return false;
		}else{
			int[] coordinates = GetCoordinates(x, y, direction);
			return helper(maze, coordinates[0], coordinates[1], destination, direction);
		}
	}
	
	private int[] GetCoordinates(int x, int y, int direction) {
		int[] coordinates = new int[2];
		coordinates[0] = x+directions[direction][0];
		coordinates[1] = y+directions[direction][1];
		return coordinates;
	}

	
	public boolean IsTouchingWallInDirection(int x, int y, int[][] maze, int direction){
		int a = x+directions[direction][0];
		int b = y+directions[direction][1];
		if(a<0 || a>=maze.length || b<0 || b>=maze[0].length || maze[a][b]==1){    
			return true;
		}

		return false;
	}  
}
