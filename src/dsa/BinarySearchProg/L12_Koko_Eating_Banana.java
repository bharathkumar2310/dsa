package dsa.BinarySearchProg;

import java.util.Arrays;

public class L12_Koko_Eating_Banana {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles). max().getAsInt();
        int ans = Integer.MAX_VALUE;;

        while(start <= end) {
            int mid = (start + end)/ 2;
            int ans1 = func(mid, piles);
            if(ans1 <= h ) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }

    int func(int mid, int[] arr) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            count += Math.ceil((double)arr[i] / mid);
        }
        return count;
    }
}

//TC : O(nlogm + 2n) == O(nlogm) // m is max
//SC : O(1)