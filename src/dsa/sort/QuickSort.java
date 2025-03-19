package dsa.sort;

import java.util.List;

public class QuickSort {
	
	public void sort(List<Integer>list) {
		
		divide(list, 0, list.size()-1);
	}

	private void divide(List<Integer> list, int i, int j) {
		
		if(i >=j) {
			return;
		}
		
		int pElement = qsort(list,i,j);
		
		divide(list, i, pElement-1 );
		divide(list, pElement+1,j );
		
		
		
	}

	private int qsort(List<Integer> list, int i, int j) {
		int k=i-1;
		int pivotElement = list.get(j);
		for(int l=i; l<= j-1; l++) {
			
			
			if(list.get(l) <= pivotElement) {
				k++;
				swap(l,k,list);
			}
			
			
		}
        swap(k + 1, j, list);
		
		return k+1;
		
	}

	void swap(int i, int j, List<Integer>list) {
		Integer temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

}
