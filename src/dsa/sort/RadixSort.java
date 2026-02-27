package dsa.sort;


import java.util.List;

public class RadixSort {

    // 191, 203, 65, 293, 59,603, 105, 101, 301, 1001, 97, 106
    public void sort(List<Integer> numbers) {

        int maxElement = numbers.stream().max(Integer :: compareTo).get();
        for(int pos = 1; maxElement/pos > 0 ; pos *= 10) {
            int[] output = new int[numbers.size()];
            radixSort(numbers, pos, output);
        }
    }

    public void radixSort(List<Integer> numbers, int pos, int[] output) {

        int[] freqCount = new int[10];
        for(int i=0; i<numbers.size(); i++)  {
            freqCount[(numbers.get(i)/pos) % 10]++;
        }

        for(int i=1; i<10; i++) {
            freqCount[i] += freqCount[i-1];
        }

        for(int i=numbers.size() - 1; i>=0; i--) {
            freqCount[(numbers.get(i)/pos) % 10]--;
            output[freqCount[(numbers.get(i)/pos) % 10]] = numbers.get(i);
        }

        for(int i=0; i<output.length; i++) {
            numbers.set(i,output[i]);
        }

    }
}