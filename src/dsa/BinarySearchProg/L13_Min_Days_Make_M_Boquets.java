package dsa.BinarySearchProg;

import java.util.Arrays;

public class L13_Min_Days_Make_M_Boquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int start = Arrays.stream(bloomDay).min().getAsInt();
        int end = Arrays.stream(bloomDay).max().getAsInt();
        int ans = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end)/ 2;
            int ans1 = func(mid, bloomDay, k);
            if(ans1 >= m) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int func(int mid, int[] bloomDay, int k) {
        int count = 0;
        int totalCount = 0;
        int sum = 0;
        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= mid) {
                count++;
            }
            else {
                totalCount += count / k;
                count = 0;
            }

        }
        totalCount += count/k;
        return totalCount;
    }
}


//TC : O(nlogm + 2n) ---> m---> min to max
//SC : O(1)