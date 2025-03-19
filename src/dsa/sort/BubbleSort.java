package dsa.sort;

import java.util.Comparator;
import java.util.List;
//1.Start at the beginning of the list.
//2.Compare the first two adjacent elements.
//3.If the first element is larger than the second, swap them.
//4.Move to the next pair of adjacent elements and repeat until you reach the end of the list.
//5.The largest element will be at the end of the list after the first pass.
//6.Repeat the process for the remaining elements (ignoring the last sorted elements).
//7.Stop when no swaps are needed, meaning the list is sorted.

//TC: O(n^2)
//SC: O(1)
public class BubbleSort {
	Comparator<Integer> comparator;
	
	public BubbleSort(){
		this.comparator = Comparator.naturalOrder();
	}
	
	public BubbleSort(Comparator<Integer> comparator) {
		this.comparator = comparator;
	}
 
	boolean swapped ;

	public void sort(List<Integer>list) {
		
		for(int i=0; i<list.size(); i++) {
			swapped = false;
			for(int j=0; j<list.size()-1-i; j++) {
				if(comparator.compare(list.get(j), list.get(j+1)) > 0) {
					swap(j, j+1, list);
					swapped = true;
				}
			}
			if(swapped == false) {
				break;
			}
		}
	}

	void swap(int i, int j, List<Integer>list) {
		Integer temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
}




