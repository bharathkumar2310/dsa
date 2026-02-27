package dsa.sort;

import java.util.List;

public class CountingSort {

    public void  sort(List<Integer> numbers) {

        int maxValue = numbers.stream().max(Integer::compareTo).get(); // O(n)

        int[] freqCount = new int[maxValue + 1];
        int[] output = new int[numbers.size()];
        for(Integer number : numbers) {     // O(n)
            freqCount[number]++;
        }

        for(int i=1; i<freqCount.length; i++) {
            freqCount[i] += freqCount[i-1];
        }

        for(int i=numbers.size() - 1; i>=0; i--) {
            freqCount[numbers.get(i)]--;
            output[freqCount[numbers.get(i)]] = numbers.get(i);
        }

        for(int i=0; i<output.length; i++) {
            numbers.set(i,output[i]);
        }
    }

}


// TC : O(2n + K) = O(n + k)
// K can be reduced to max - min

//SC : O(K)

//1. We find the max number and create a freq Array = max number + 1
//2. We iterate each number and find their frequency
//3. Based on the frequency we set the numbers in sorted order in numbers list


//This can be used only for smaller numbers , if the range grows bigger both TC and SC will grow

// By default Counting Sort doesnot work for negative nos but we can modify it to make it work