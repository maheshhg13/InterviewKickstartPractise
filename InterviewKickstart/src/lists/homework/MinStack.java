package lists.homework;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

class myStack{
	List<Integer> data = new ArrayList<Integer>();
	
	public void push(int item){
		data.add(item);
	}
	
	public int peek(){
		if(data.isEmpty()){
			throw new EmptyStackException();
		}
		return data.get(data.size()-1);
	}
	
	public boolean isEmpty(){
		return data.isEmpty();
	}
	
	public int pop(){
		if(data.isEmpty()){
			throw new EmptyStackException();
		}
		int d = peek();
		data.remove(data.size()-1);
		return d;
	}
}

public class MinStack {
	myStack stk;
	myStack min;
	
	public MinStack(){
		stk = new myStack();
		min = new myStack();
	}
	
	public void push(int item){
		stk.push(item);
		if(min.isEmpty()){
			min.push(item);
		}else{
			min.push(Math.min(min.peek(), item));
		}
	}
	
	public Integer pop(){
		if(stk.isEmpty()){
			return null;
		}
		min.pop();
		return stk.pop();
	}
	
	public Integer min(){
		if(min.isEmpty()){
			return null;
		}
		return min.peek();
	}
	
	public Integer peek(){
		if(stk.isEmpty())
			return null;
		return stk.peek();
	}
	
	public boolean isEmpty(){
		return stk.isEmpty();
	}
	
	public static void main(String[] args) {
		MinStack min = new MinStack();
		int[] data = {1,5,3,0};
		for(int x:data){
			min.push(x);
			System.out.println("Item: "+x+" min: "+min.min());
		}
		
	}

}

