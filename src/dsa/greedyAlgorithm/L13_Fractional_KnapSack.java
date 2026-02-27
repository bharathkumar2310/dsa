package dsa.greedyAlgorithm;

import java.util.Arrays;

class L13_Fractional_KnapSack {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        Integer[] index = new Integer[val.length];

        for(int i=0; i<val.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> Double.compare(
                (double) val[b] / wt[b],
                (double) val[a] / wt[a]
        ));

        double ans = 0;
        int j = 0;
        while(capacity > 0 && j<index.length) {
            if(capacity - wt[index[j]] >= 0) {
                capacity -= wt[index[j]];
                ans += val[index[j]];
            }
            else {
                ans += ((double)val[index[j]]/wt[index[j]]) * capacity;
                capacity = 0;
            }
            j++;
        }

        return ans;



    }
}


//TC : O(nlogn + n)
//SC : O(n)