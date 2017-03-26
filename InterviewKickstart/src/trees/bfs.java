package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bfs {
	public static void iterative(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = q.poll();
			if(temp!=null){
				System.out.print(temp.value+" ");
				q.add(temp.left);
				q.add(temp.right);
			}
		}
	}
	
	public static void recursive(List<Node> nodes){
		if(nodes.size()==0){
			return;
		}
		
		List<Node> next = new ArrayList<Node>();
		for(Node x:nodes){
			if(x!=null){
				System.out.print(x.value+" ");
				next.add(x.left);
				next.add(x.right);
			}
		}
		recursive(next);
	}
	
	public static void main(String[] args) {
		Node tree = dfs.getTree();
		iterative(tree);
		List<Node> temp = new ArrayList<Node>();
		temp.add(tree);
		System.out.println();
		recursive(temp);
	}
}
