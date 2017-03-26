package trees;

public class printPath {

	public static void printPath(Node root, int target, String temp){
		if(root == null){
			return;
		}else if(root.value==target){
			System.out.println(temp+root.value);
		}
		printPath(root.left, target, temp+root.value+"->");
		printPath(root.right, target, temp+root.value+"->");
	}
	public static void main(String[] args) {
		Node root = dfs.getTree();
		printPath(root, 22, "");
	}
}
