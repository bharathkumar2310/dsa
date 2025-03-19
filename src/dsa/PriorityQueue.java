package dsa;

import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueue {
	
	ArrayList<Integer>pq = new ArrayList<>();
	Comparator<Integer> comparator;
	
	 public PriorityQueue(Comparator<Integer> comparator) {
	        this.comparator = comparator != null ? comparator : Comparator.naturalOrder(); // Default to min-heap if no comparator
	    }
	
	
	void add(int val) {
		pq.add(val);
		int i = pq.size()-1;
		heapifyUp(i);
		
   }
	
   int pop() {
	   int returnValue = pq.get(0);
	   pq.set(0, pq.get(pq.size()-1));
	   pq.remove(pq.size()-1);
	   heapifyDown(0);
	   return returnValue;
	   
   }


	int parent (int index) {
		   return (index - 1)/2;
	   }
	
	int right (int index) {
		return index*2 + 2;
	}
	
	int left(int index) {
		return index*2 + 1;
	}
   
   void swap(int i, int parent) {
	    int temp = pq.get(i);
	    pq.set(i, pq.get(parent));
	    pq.set(parent, temp);
   }
   
   void heapifyUp(int i) {
	   while (i > 0 && comparator.compare(pq.get(i), pq.get(parent(i))) < 0)  {	
				swap(i , parent(i));
				i = parent(i);
			
		}
   }
   
   
   void heapifyDown(int i) {
	   
	   int extreme = i;
	   int left = left(i);
	   int right = right(i);
	   if(left<pq.size() && comparator.compare(pq.get(left), pq.get(extreme)) < 0) {
		   extreme = left;
	   }
	   if(right<pq.size() && comparator.compare(pq.get(right), pq.get(extreme)) < 0) {
		   extreme = right;
	   }
	   swap(extreme, i);
	   heapifyDown(extreme);
	   
   }


}