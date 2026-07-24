package dsa.dp;

public class L5_House_Robber_Sum_Of_Non_Adj_Ele {
    public int rob(int[] nums) {

        int next = 0;
        int next1 = 0;

        for(int i=nums.length -1 ; i>=0; i--) {
            int pick =  nums[i] + next1;
            int notPick = next;

            int curr = Math.max(pick,notPick);
            next1 = next;
            next = curr;
        }

        return next;
    }
}

//TC : O(n)
//SC : O(1)



//public int rob(int[] nums) {
//    int[] dp = new int[nums.length + 2];
//
//    for(int i=nums.length -1 ; i>=0; i--) {
//        int pick =  nums[i] + dp[i+2];
//        int notPick = dp[i+1];
//
//        dp[i] = Math.max(pick,notPick);
//    }
//
//    return dp[0];
//}


//TC : O(n)
//SC : O(n)



//public int rob(int[] nums) {
//    int[] dp = new int[nums.length];
//    Arrays.fill(dp, -1);
//    return rec(0, nums, dp);
//}
//
//int rec(int i, int[] nums, int[] dp) {
//    if(i>=nums.length) {
//        return 0;
//    }
//
//    if(dp[i] != -1) {
//        return dp[i];
//    }
//
//    int pick =  nums[i] + rec(i+2, nums, dp);
//    int notPick = rec(i+1, nums, dp);
//
//    return dp[i] = Math.max(pick,notPick);
//}


//TC : O(n)
//SC : O(2n)


//public int rob(int[] nums) {
//    return rec(0, nums);
//}
//
//int rec(int i, int[] nums) {
//    if(i>=nums.length) {
//        return 0;
//    }
//
//    int pick =  nums[i] + rec(i+2, nums);
//    int notPick = rec(i+1, nums);
//
//    return Math.max(pick,notPick);
//}

//TC : O(2^n)
//SC : O(n)