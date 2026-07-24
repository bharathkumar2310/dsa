package dsa.BinarySearchProg;

import java.util.Arrays;

public class L15_Capacity_Ship_Package_Within_D_Days {
    public int shipWithinDays(int[] weights, int days) {
        int start = Arrays.stream(weights).max().getAsInt();
        int end = Arrays.stream(weights).sum();
        int ans = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end) / 2;
            int ans1 = func(weights, mid);
            if(ans1 <= days) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
    }

    int func(int[] weights, int mid) {
        int ans = 0;
        int count = 0;
        for(int i=0; i<weights.length; i++) {
            if(ans + weights[i] <= mid) {
                ans += weights[i];
            }
            else {
                count++;
                ans = weights[i];
            }
        }
        count++;
        return count;
    }
}

//TC : O(nlogn)
//SC : O(1)