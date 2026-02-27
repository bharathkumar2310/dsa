package dsa.greedyAlgorithm;

import java.util.Arrays;

//optimal greedy soln
class L5_Jump_Game_2 {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int jumps = 0;
        while(right < nums.length - 1 ) {
            int maxIndex = 0;
            for(int i= left; i<= right; i++) {
                maxIndex = Math.max(maxIndex, i+nums[i]);
            }
            jumps++;
            left = right + 1;
            right = maxIndex;
        }
        return jumps;
    }
}



//rec soln

//class L5_Jump_Game_2 {
//    public int jump(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//        return rec(0,nums, dp);
//    }
//
//    int rec(int i, int[] nums, int[] dp) {
//
//        if(i>=nums.length - 1) {
//            return 0;
//        }
//        if(dp[i] != -1) {
//            return dp[i];
//        }
//        int min = (int)1e9;
//        for(int j=i+1; j <= Math.min(i + nums[i], nums.length - 1); j++) {
//            min = Math.min(min, 1 + rec(j, nums, dp));
//        }
//        return dp[i] = min;
//    }
//}