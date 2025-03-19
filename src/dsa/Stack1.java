package dsa;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack1 {

	ArrayList<Integer>stack = new ArrayList<>() ;
	
	
	void push(int element) {
		stack.add(element);
	}
	
	int pop() throws NoSuchElementException {
		if(!isEmpty()) {
			int poppedElement = stack.remove(stack.size()-1);
			return poppedElement;
		}
		throw new NoSuchElementException("Stack is empty");
	}
	
	boolean isEmpty() {
		return stack.isEmpty();
	}
	
	ArrayList<Integer> print() {
		return stack;
	}
	
	
	
	int peek() throws NoSuchElementException {
		if(!isEmpty()) {
			return stack.get(stack.size()-1);
		}
		else {
			throw new NoSuchElementException("Stack is empty");
		}
	}
	
	
	int size() {
		return stack.size();
	}
	
	void clear() {
		stack.clear();
	}
	
	
	int search(int element) {
		int index = stack.lastIndexOf(element);
		if(index == -1) {
			return -1; // no element found
		}
		return stack.size()-index; // return position of element
	}
}
