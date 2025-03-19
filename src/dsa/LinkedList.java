package dsa;

import java.util.NoSuchElementException;

public class LinkedList {
	
	Node head;
	Node current;
	
	
	void add(int data) {
		
		Node node = new Node(data);
		if(head == null ) {
			 head = node;
			 current = node;
		}
		else {
			current.next = node;
			current = node;
		}
		
	}
	
	
	void printList(){
		Node curr = head;
		while(curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	
	void addFirst(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;

	}
	
	
	void add(int index, int data)throws IndexOutOfBoundsException {
		Node node = new Node(data);
		Node curr = head;
		int count = 0;
		if(index < 0) {
			throw new IndexOutOfBoundsException("index out of bounds");

		}
		if(index == 0) {
			node.next = head;
			head = node;
			return;
		}
		while(curr != null && count != index-1) {
			curr = curr.next;
			count++;
		}
		if(curr == null) {
			throw new IndexOutOfBoundsException("index out of bounds");
		}
		else {
			node.next = curr.next;
		    curr.next = node;
		}
	}
	
	
	void removeFirst() {
		 if (head == null) {
		        throw new NoSuchElementException("List is empty");
		    }
		Node curr = head;
		head = head.next;
		curr.next = null;
	}
	
	
	void removeLast() {
		if (head == null) {
	        throw new NoSuchElementException("List is empty");
	    }
		
		if (head.next == null) {  
	        head = null;
	        return;
	    }
		Node curr = head;
		Node prev =curr;
		while(curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = null;
	}
	
	void remove(int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException("index out of bounds");

		}
		Node curr = head;
		Node prev = null;
		int count =0;
		if(index == 0 || head == null) {
			head = head.next;
            return;
        }
		while(curr != null && count < index-1) {
			prev =curr;
			curr =curr.next;
		}
		if (curr == null) {
	        throw new IndexOutOfBoundsException("Index out of bounds");
	    }
		
		prev.next = curr.next;
		curr.next = null;
	}
	
	
}

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
	}
}