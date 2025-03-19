package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import dsa.bit.BitProbs;
import dsa.sort.BubbleSort;
import dsa.sort.InsertionSort;
import dsa.sort.MergeSort;
import dsa.sort.QuickSort;
import dsa.sort.SelectionSort;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack1 s = new Stack1();
		s.push(1);
		s.push(2);
		System.out.println(s.print());
		int popElement = s.pop();
		System.out.println(popElement);
		System.out.println(s.print());
 
		
		BinarySearch bs = new BinarySearch();
		List<Integer>inp = List.of(0,1,2,3,4,5,6);
		System.out.println(bs.search(inp, 4));
		
		
		BubbleSort bubbleSort = new BubbleSort();
		BubbleSort bubbleSort1 = new BubbleSort(Comparator.reverseOrder());
		List<Integer> bsList = Arrays.asList(8,4,9,2,3,1,8);
		bubbleSort.sort(bsList);
		System.out.println("bubbleSort in ascendingOrder" + bsList.toString());	
		bubbleSort1.sort(bsList);
		System.out.println("bubblesort in descendingOrder" + bsList.toString());

		SelectionSort selectionSort = new SelectionSort();
		SelectionSort selectionSort1 = new SelectionSort(Comparator.reverseOrder());
		List<Integer> ssList = Arrays.asList(8,4,9,2,3,1,8);
		selectionSort.sort(ssList);
		System.out.println("selectionSort in ascendingOrder" + ssList.toString());	
		selectionSort1.sort(ssList);
		System.out.println("selectionSort in descendingOrder" + ssList.toString());
		
		
		
		InsertionSort insertionSort = new InsertionSort();
		List<Integer> isList = Arrays.asList(8,4,9,2,3,1,8);
		insertionSort.sort(isList);
		System.out.println("insertionSort in ascendingOrder" + isList.toString());	
		
		
		
		MergeSort mergeSort = new MergeSort();
		List<Integer> msList = Arrays.asList(8,4,9,2,3,1,8);
		mergeSort.sort(msList);
		System.out.println("mergeSort in ascendingOrder" + msList.toString());
		
		
		QuickSort quickSort = new QuickSort();
		List<Integer> qsList = Arrays.asList(8,4,9,2,3,1,8);
		quickSort.sort(qsList);
		System.out.println("quickSort in ascendingOrder" + qsList.toString());

		

		BitProbs bitProb = new BitProbs();
		List<Integer> input1 = Arrays.asList(8,4,9,2,3,1,8);
		System.out.println("oddOrEven" + bitProb.oddOrEven(input1).toString());
		
		System.out.println("powerOf2" + bitProb.powerOf2(input1).toString());
		
		System.out.println("noOfbitsHaving1" + bitProb.noOfbitsHaving1(input1).toString());


	}

}
