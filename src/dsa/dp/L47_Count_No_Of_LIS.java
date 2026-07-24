package dsa.dp;

import java.util.Arrays;

public class L47_Count_No_Of_LIS {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        int ans1 = 0;
        int[] cnt = new int[nums.length];
        Arrays.fill(cnt, 1);

        Arrays.fill(dp, 1);

        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[i] < 1+ dp[j]) {
                        cnt[i] = cnt[j];
                        dp[i] = dp[j] + 1;
                    }
                    else if(dp[i] == 1 + dp[j]) {
                        cnt[i] += cnt[j];
                    }
                    ans = Math.max(ans,dp[i]);
                }
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(dp[i] == ans) {
                ans1+=cnt[i];
            }
        }

        return ans1;
    }
}
