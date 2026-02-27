package dsa.Collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueueCopy<T extends Comparable<T>> {

    private Comparator<T> comparator;
    private List<T> arrayList;

    public PriorityQueueCopy() {
        this.arrayList = new ArrayList<>();
        this.comparator = Comparator.naturalOrder(); // T must be Comparable
    }

    public PriorityQueueCopy(Comparator<T> comparator) {
        this.arrayList = new ArrayList<>();
        this.comparator = comparator;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        T temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }

    public void add(T t) {
        arrayList.add(t);
        int curr = arrayList.size() - 1;

        // Min-heap: swap while parent > current
        heapifyUp(curr);
    }

    public T peek() {
        if (arrayList.isEmpty()) return null;
        return arrayList.get(0);
    }

    public T remove() {
        if (arrayList.isEmpty()) return null;

        T removed = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size() - 1));
        arrayList.remove(arrayList.size() - 1);
        if (!arrayList.isEmpty()) heapifyDown(0);
        return removed;
    }

    public void heapifyUp(int curr) {
        while (curr > 0 && comparator.compare(arrayList.get(curr), arrayList.get(parent(curr))) < 0) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    private void heapifyDown(int i) {
        int minIndex = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < arrayList.size() && comparator.compare(arrayList.get(left), arrayList.get(minIndex)) < 0) {
            minIndex = left;
        }

        if (right < arrayList.size() && comparator.compare(arrayList.get(right), arrayList.get(minIndex)) < 0) {
            minIndex = right;
        }

        if (minIndex != i) {
            swap(minIndex, i);
            heapifyDown(minIndex);
        }
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public int size() {
        return arrayList.size();
    }
}
