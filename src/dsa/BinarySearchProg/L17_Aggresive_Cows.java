package dsa.BinarySearchProg;

import java.util.Arrays;

public class L17_Aggresive_Cows {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int start = 1;
        int ans = 0;
        int end  = Arrays.stream(stalls).max().getAsInt() - Arrays.stream(stalls).min().getAsInt();
        while(start <= end) {
            int mid = (start + end) / 2;
            int ans1 = func(stalls, mid);
            if(ans1 >= k) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            }
            else {
                end = mid -1;
            }
        }
        return ans;
    }


    int func(int[] stalls, int mid) {
        int count = 1;
        int pres = stalls[0];
        for(int i=1; i<stalls.length; i++) {
            if(stalls[i] - pres >= mid) {
                count++;
                pres = stalls[i];
            }
        }
        return count;

    }
}

//TC : O(nlogn)
//SC : O(1)