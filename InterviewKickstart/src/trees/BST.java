package trees;

public class BST {
	Node root;
	
	public void insert(int n){
		if(root==null){
			root = new Node(n);
		}else{
			insertHelper(root, n);
		}
	}
	
	public void insertHelper(Node root, int n){
		if(n>root.value){
			if(root.right==null){
				root.right = new Node(n);
			}else{
				insertHelper(root.right, n);
			}
		}else{
			if(root.left==null){
				root.left = new Node(n);
			}else{
				insertHelper(root.left, n);
			}
		}
	}
	
	public static void insertIter(Node root, int n){
		if(root==null){
			root = new Node(n);
		}
		Node temp = root;
		while(temp!=null){
			if(n>temp.value){
				if(temp.right==null){
					temp.right = new Node(n);
					break;
				}
				temp = temp.left;
			}else{
				if(temp.left==null){
					temp.left = new Node(n);
					break;
				}
				temp = temp.right;
			}
		}
	}
}
