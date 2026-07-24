package dsa.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrioirtyQueue1<T> {

    public Comparator<T> comparator;
    public ArrayList<T> arrayList;

    public PrioirtyQueue1() {
        this.comparator = (Comparator<T>) Comparator.naturalOrder();
        this.arrayList = new ArrayList<>();
    }
    public PrioirtyQueue1(Comparator<T> comparator) {
        this.comparator = comparator;
        this.arrayList = new ArrayList<>();
    }


    public boolean offer(T t) {
        arrayList.add(t);
        heapify();
        return true;
    }

    public T poll() {
        if(arrayList.isEmpty()) {
            throw new RuntimeException("empty");
        }
        Collections.swap(arrayList, 0 , arrayList.size() - 1);
        T t = arrayList.remove(arrayList.size() - 1);
        heapifyDown(0);
        return t;
    }

    public void heapifyDown(int i) {

        int ind = i;
        int leftInd = leftChild(ind);
        int rightInd = rightChild(ind);


        if(leftInd< arrayList.size()  && comparator.compare(arrayList.get(ind), arrayList.get(leftInd) ) > 0) {
            ind = leftInd;
        }
         if(rightInd< arrayList.size()  && comparator.compare(arrayList.get(ind), arrayList.get(rightInd) ) > 0) {
            ind = rightInd;
        }

        if(ind != i) {
            Collections.swap(arrayList, i , ind);
            i = ind;
            heapifyDown(i);
        }


    }

    public void heapify()  {

        if(arrayList.size() == 1) {
            return;
        }

        int ind = arrayList.size() -1;

        while(ind > 0 && comparator.compare(arrayList.get(parent(ind)), arrayList.get(ind)) > 0) {
            Collections.swap(arrayList, parent(ind) , ind);
            ind = parent(ind);
        }


    }


    public int parent(int i) {
        return (i - 1)/2;
    }

    public int leftChild(int i) {
        return i*2 + 1;
    }

    public int rightChild(int i) {
        return i*2 + 2;
    }

}
