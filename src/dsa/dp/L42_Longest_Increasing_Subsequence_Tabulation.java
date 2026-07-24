package dsa.dp;

import java.util.Arrays;

public class L42_Longest_Increasing_Subsequence_Tabulation {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i=0; i< nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1+ dp[j]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        return ans;
    }
}

//TC : O(n^2)
//SC : O(n)