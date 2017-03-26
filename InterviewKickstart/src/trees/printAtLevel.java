package trees;

public class printAtLevel {
	
	public static void printAtLevelDFS(Node root, int level){
		if(root==null){
			return;
		}else if(level==0){
			System.out.println(root.value);
			return;
		}
		printAtLevelDFS(root.left, level-1);
		printAtLevelDFS(root.right, level-1);
	}
	
	public static void printAtLevelBFS_iterative(Node root, int level){
		
	}
	
	public static void main(String[] args) {
		Node root = dfs.getTree();
		printAtLevelDFS(root, 1);
	}

}
