package lists.homework;

import java.util.LinkedList;
import java.util.List;

public class SuperStack {
	static class myStack{
		LinkedList <Integer> data;
        public myStack(){
            data = new LinkedList<Integer>();
        }
        public int pop(){
            int value = data.getLast();
            data.removeLast();
            return value;
        }
        
        public void push(int value){
            data.addLast(value);
        }
        
        public boolean isEmpty(){
            return data.isEmpty();
        }
        
        public int peek(){
            return data.getLast();
        }
        
        public void inc(int k, int n){
        	int[] arr = new int[k];
        	for(int i=0;i<k;i++){
        		arr[i]=data.getFirst()+n;
        		data.removeFirst();
        	}
        	for(int i=k;i>=0;--i){
        		data.addFirst(arr[i]);
        	}
        }
    }
    static void superStack(String[] operations) {
        myStack stk = new myStack();
        for(String opr : operations){
            String[] values = opr.split(" ");
            if(values.length==1){
                stk.pop();
                if(stk.isEmpty()){
                    System.out.println("EMPTY");
                }else{
                    System.out.println(stk.peek());
                }
            }else if(values.length==2){
                int value = Integer.parseInt(values[1]);
                stk.push(value);
                if(stk.isEmpty()){
                    System.out.println("EMPTY");
                }else{
                    System.out.println(stk.peek());
                }
            }else{
                int k = Integer.parseInt(values[1]);
                int n = Integer.parseInt(values[2]);
                stk.inc(k, n);
                if(stk.isEmpty()){
                    System.out.println("EMPTY");
                }else{
                    System.out.println(stk.peek());
                }
            }
        }

    }


}
