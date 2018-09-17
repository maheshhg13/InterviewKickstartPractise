package lists.homework;

import trees.printAtLevel;

class LLNode{
	int val;
	LLNode next;
	public LLNode(int l){
		val = l;
	}
}

public class ReverseLLGroup {
	
	public static LLNode rev(LLNode head, int k){
		LLNode prev = null;
		LLNode next = null;
		LLNode curr = head;
		int count = 0;
		while(count < k && curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count ++;
		}
		if(next!=null){
			head.next = rev(next, k);
		}
		return prev;
				
	}

	public static void printLL(LLNode head){
		LLNode temp = head;
		while(temp!=null){
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LLNode one = new LLNode(1);
		LLNode two = new LLNode(2);
		LLNode three = new LLNode(3);
		LLNode four = new LLNode(4);
		LLNode five = new LLNode(5);
		LLNode six = new LLNode(6);
		LLNode seven = new LLNode(7);
		LLNode eight = new LLNode(8);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		seven.next = eight;
		
		LLNode head = rev(one, 3);
		while(head!=null){
			System.out.print(head.val+"->");
			head = head.next;
		}
		
	}
}
