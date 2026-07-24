package dsa.dp;

import java.util.ArrayList;

public class L43_LIS_Binary_Search {
    public int lengthOfLIS(int[] nums) {

        ArrayList<Integer> dp = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            if(dp.size() == 0 || dp.get(dp.size() -1) < nums[i]) {
                dp.add(nums[i]);
            }
            else {
                int index  = lowerBound(dp, nums[i]);
                dp.set(index, nums[i]);
            }
        }

        return dp.size();

    }

    int lowerBound(ArrayList<Integer> dp , int num) {
        int st = 0;
        int end = dp.size() -1;
        int ans = (int)1e9;

        while(st<= end) {
            int mid = (st + end) / 2;
            if(dp.get(mid) >= num ) {
                ans = Math.min(mid, ans);
                end = mid -1;
            }
            else {
                st = mid + 1;
            }
        }
        return ans;
    }
}

//TC : O(nlogn)
//SC : O(n)