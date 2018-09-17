package lists.homework;
class LinkedListNode{
	int val;
	LinkedListNode next;
	public LinkedListNode(int x){
		val = x;
	}
}
public class MergeSortLL {
	static LinkedListNode fn = new LinkedListNode(-1);
    static LinkedListNode divide(LinkedListNode node){
        if(node == null || node.next==null){
            return node;
        }
        LinkedListNode slow = node;
        LinkedListNode fast = node.next;
        while(fast.next!=null){
        	slow = slow.next;
            fast = fast.next;
            if(fast.next!=null){
                fast = fast.next;
            }
        }
        fast = slow.next;
        slow.next = null;
        System.out.println("One........");
        printLL(node);
        System.out.println("Two........");
        printLL(fast);
        
        return merge(divide(node), divide(fast));
    }
    
    public static LinkedListNode merge(LinkedListNode a, LinkedListNode b){
        LinkedListNode temp = new LinkedListNode(-1);
        LinkedListNode result = temp;
        while(a!=null && b!=null){
            if(a.val<b.val){
                result.next = a;
                a = a.next;
            }else{
                result.next = b;
                b = b.next;
            }
            result = result.next;
        }
        if(a!=null){
            result.next = a;
        }else if(b!=null){
            result.next = b;
        }
        return temp.next;
    }
    public static void printLL(LinkedListNode head){
    	LinkedListNode temp = head;
    	while(temp!=null){
    		System.out.print(temp.val+", ");
    		temp = temp.next;
    	}
    	System.out.println();
    }
    public static void main(String[] args) {
    	LinkedListNode a = new LinkedListNode(1);
    	LinkedListNode b = new LinkedListNode(3);
    	LinkedListNode c = new LinkedListNode(2);
    	LinkedListNode d = new LinkedListNode(4);
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	
    	printLL(divide(a));
    	
	}
}
