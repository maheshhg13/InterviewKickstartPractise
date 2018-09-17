package lists.homework;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Node<K, V>{
	K key;
	V value;
	Node<K, V> next;
	Node<K, V> prevous;
	public Node(K key, V value){
		this.key = key;
		this.value = value;
	}
}
class DoublyLinkedList<K, V>{
	Node<K, V> head;
	Node<K, V> tail;
	
	public void add(Node<K, V> temp){
		if(head == null){
			head = temp;
			tail = temp;
		}else{
			tail.next = temp;
			temp.prevous = tail;
			temp.next = null;
			tail = temp;
		}
		printLL();
	}
	
	public void moveToTail(Node<K, V> temp){
		if(temp==tail){
		    printLL();
			return;
		}else if(temp==head){
			head = head.next;
		}else{
			temp.prevous.next = temp.next;
			temp.next.prevous = temp.prevous;
		}
		add(temp);
	}
	
	public K removeHead() {
		K key = null;
		if (head == null) {
			return null;
		} else if (head == tail) {
			key = tail.key;
			head = tail = null;
		} else {
			key = head.key;
			head = head.next;
			head.prevous = null;
		}
		printLL();
		return key;
	}
 	public void printLL(){
 	    Node<K, V> temp = head;
 	    while(temp!=null){
 	        System.out.print("[Key: "+temp.key+" Value: "+temp.value+"]");
 	        temp = temp.next;
 	    }
 	    System.out.println();
 	}
}
public class LRUCache<K, V> {
	Map<K, Node<K, V>> map;
	DoublyLinkedList<K, V> list;
	int capcacity;
	public LRUCache(int capacity){
		this.capcacity = capacity;
		map = new HashMap<K, Node<K, V>>();
		list = new DoublyLinkedList<K, V>();
	}
	
	public V get(V key){
	    //System.out.println("Get: key: "+key);
		if(map.containsKey(key)){
			list.moveToTail(map.get(key));
			return map.get(key).value;
		}
		return null;
	}
	
	public void put(K key, V val) {
	    //System.out.println("PUT: key: "+key+" value: "+val);
		if (map.containsKey(key)) {
			map.get(key).value = val;
			list.moveToTail(map.get(key));
		} else {
			if (map.size() >= capcacity) {
				K k = list.removeHead();
				if (k != null) {
					map.remove(k);
				}
			}
			Node<K, V> temp = new Node<K, V>(key, val);
			map.put(key, temp);
			list.add(temp);
		}

	}
}