package dsa;

import java.util.List;

public class BinarySearch {

	
	
	int search(List<Integer> arr, int val) {
		
		int low =0;
		int high = arr.size()-1;
		
		while(high >= low) {
			int mid = (high-low)/2 + low;

			if(arr.get(mid) == val) {
				return mid;
			}
			
		     if(arr.get(mid) > val) {
				high = mid-1;
			}
		     else if(arr.get(mid)<val) {
		    	 low = mid +1;

		     }
		}
		return -1;
	}
}
