package dsa.sort;

import java.util.Comparator;
import java.util.List;

public class SelectionSort {
	
//	1. First we find the smallest element and swap it with the first element. 
//	   This way we get the smallest element at its correct position.
//	2. Then we find the smallest among remaining elements (or second smallest) and 
//	    swap it with the second element.
//	3.  We keep doing this until we get all elements moved to correct position.
	
	//TC: O(n^2)
	//SC: O(1)
	Comparator<Integer> comparator ;
	
	public SelectionSort(Comparator<Integer> comparator){
		this.comparator = comparator;
	}
	public SelectionSort(){
		this.comparator = Comparator.naturalOrder();
	}
	
	public void sort(List<Integer> list) {
		
		for(int i=0; i<list.size()-1; i++) {
			int min = i;
			for(int j=i+1; j<list.size(); j++) {
				if(comparator.compare(list.get(j), list.get(min)) < 0) {
					min = j;
				}
			}
			swap(i,min, list);
		}
	}

	public void swap(int i, int min,List<Integer>list) {
		int temp = list.get(i);
		list.set(i, list.get(min));
		list.set(min, temp);
		
	}

}
