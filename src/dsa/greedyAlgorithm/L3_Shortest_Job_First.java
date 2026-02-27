package dsa.greedyAlgorithm;

import java.util.Arrays;

class L3_Shortest_Job_First {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int totalSum = 0;
        int sum = 0;
        for(int i=0; i<bt.length -1; i++) {
            sum += bt[i];
            totalSum+=sum;
        }

        return totalSum/bt.length;
    }
}

//TC:O(nlogn)
//SC:O(1)