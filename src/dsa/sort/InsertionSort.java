package dsa.sort;

import java.util.List;

public class InsertionSort {

	
	
	//TC: O(n^2)
	//SC: O(1)
	public void sort(List<Integer>list) {
		
		for(int i=1; i<list.size(); i++) {
			int j = i-1;
			int current = list.get(i);
			while(j>= 0 && list.get(j) > current) {
				list.set(j+1, list.get(j));
				j--;
			}
			list.set(j+1, current);
		}
	}
}


//Start from the second element:
//Assume that the first element (at index 0) is already sorted.
//Begin with the second element (index 1), and compare it with the first element.
//2. Compare the current element with the sorted part of the array:
//Take the element at the current index (let’s call this the "current" element).
//Compare it with the element just before it.
//3. Shift larger elements to the right:
//If the "current" element is smaller than the element before it, shift that element one position to the right.
//Keep comparing and shifting elements to the right as long as they are greater than the "current" element.
//4. Insert the "current" element in the correct position:
//When you find an element that is smaller than or equal to the "current" element (or if you have shifted all elements), place the "current" element in its correct position.
//5. Repeat for all elements:
//Move to the next element in the list and repeat steps 2–4 until all elements have been placed in their correct position.