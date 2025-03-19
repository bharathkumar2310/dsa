package dsa.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	
	public void sort(List<Integer>list) {
		int start = 0;
		int end = list.size() - 1;
		
		divide(start, end, list);
		
	}

	public void divide(int start, int end, List<Integer> list) {

		if(start >= end) {
			return;
		}
		
		int mid = (start + end)/2;
		
		divide(start, mid, list);
		divide(mid+1,end, list);
		merge(start,end,mid,list);
	}

	public void merge(int start, int end, int mid, List<Integer> list) {
		
		List<Integer>leftArray = new ArrayList<>();
		List<Integer>rightArray = new ArrayList<>();
		
		for(int i=start; i<=mid; i++) {
			leftArray.add(list.get(i));
		}
		
		for(int j=mid+1; j<=end; j++) {
			rightArray.add(list.get(j));
		}
		
		int k=0;
		int l=0;
		int m = start;
		
		while(k<leftArray.size() && l < rightArray.size()) {
			if(leftArray.get(k) <= rightArray.get(l)) {
				list.set(m, leftArray.get(k));
				m++;
				k++;
			}
			
			else if(leftArray.get(k) > rightArray.get(l)) {
				list.set(m, rightArray.get(l));
				m++;
				l++;
			}
		}
		
		
		while(k<leftArray.size()) {
			list.set(m, leftArray.get(k));
			m++;
			k++;
		}
		
		while(l<rightArray.size()) {
			list.set(m, rightArray.get(l));
			m++;
			l++;
		}

		
		
	}

}
