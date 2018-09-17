package lists.homework;

import java.util.Stack;

public class QueueStack {
	static Stack<LinkedListNode> stk1 = new Stack<LinkedListNode>();
	static Stack<LinkedListNode> stk2 = new Stack<LinkedListNode>();
	
	public static LinkedListNode getStack(LinkedListNode head){
		LinkedListNode temp = head;
		while(temp!=null){
			
		}
		return null;
	}
	public static LinkedListNode getQueue(int[] arr){
		LinkedListNode head = new LinkedListNode(-1);
		LinkedListNode tail = head;
		for(int x:arr){
			if(head == tail){
				head.next = new LinkedListNode(x);
				tail = head.next;
			}else{
				LinkedListNode node = new LinkedListNode(x);
				tail.next = node;
				tail = tail.next;
			}
		}
		return head.next;
	}
	public static void main(String[] args) {
		
	}
	
}
