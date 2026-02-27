package dsa.sort;

import java.util.List;

public class ShellSort {


    public void sort(List<Integer> numbers) {
        int n = numbers.size();
        for(int gap = n/2; gap>0 ; gap = gap/2) {
            for(int j= gap; j<n; j++) {
                int i=j;

                while(i-gap >=0 && numbers.get(i-gap) > numbers.get((i))) {
                    swap(i-gap, i, numbers);
                    i = i-gap;
                }
            }
        }
    }

    public void swap(int i, int j,List<Integer>list) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);

    }
}
