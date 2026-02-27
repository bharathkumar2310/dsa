package dsa.sort;

import java.util.List;

public class HeapSort {

    public void sort(List<Integer>numbers) {

        int n= numbers.size();
        for(int i=n/2 - 1; i>=0; i--) {
            heapifyDown(i,n, numbers);
        }

        for(int i= n-1; i>=0; i--) {
            swap(0, i, numbers);
            heapifyDown(0, i, numbers);
        }

    }

    private void heapifyDown(int i, int heapSize, List<Integer> numbers) {
        int largest = i; // max-heap root
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < heapSize && numbers.get(left) > numbers.get(largest)) {
            largest = left;
        }

        if (right < heapSize && numbers.get(right) > numbers.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest, numbers);
            heapifyDown(largest, heapSize, numbers);
        }
    }


    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    private void swap(int i, int j, List<Integer>numbers) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }

}
