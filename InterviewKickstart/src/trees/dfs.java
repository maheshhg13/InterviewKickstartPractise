package trees;

import java.util.Stack;

class Node {
	int value;
	Node left;
	Node right;

	public Node(int c) {
		value = c;
	}
}

public class dfs {
	public static void recurse(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value + " ");
		recurse(root.left);
		recurse(root.right);
	}

	public static void iterative(Node root) {
		Stack<Node> stk = new Stack<Node>();
		stk.push(root);
		while (!stk.isEmpty()) {
			Node temp = stk.pop();
			if (temp != null) {
				System.out.print(temp.value + " ");
				stk.push(temp.right);
				stk.push(temp.left);
			}

		}
	}

	public static Node getTree() {
		Node root = new Node(1);
		Node c1 = new Node(2);
		Node c2 = new Node(3);
		Node c11 = new Node(11);
		Node c12 = new Node(12);
		Node c21 = new Node(21);
		Node c22 = new Node(22);

		c1.left = c11;
		c1.right = c12;
		
		c2.left = c21;
		c2.right = c22;
		
		root.left = c1;
		root.right = c2;
		
		return root;
	}

	public static void main(String[] args) {
		Node root = getTree();
		recurse(root);
		System.out.println();
		iterative(root);
	}

}
