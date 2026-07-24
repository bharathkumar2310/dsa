package dsa.dp;

public class L17_Count_SubSets_With_Sum_k {
    public int perfectSum(int[] nums, int target) {
        // code here
        int[] next = new int[target + 1];
        next[target] = 1;

        for(int i=nums.length -1; i>=0; i--) {
            int[] curr = new int[target + 1];
            for(int j = target; j>=0; j--) {
                int pick =0;
                if(j + nums[i] <= target) {
                    pick = next[j + nums[i]];
                }

                int notPick = next[j];

                curr[j] = pick + notPick;
            }

            next = curr;
        }

        return next[0];
    }
}

//TC : O(n * targetSum)
//SC : O(n)


//public int perfectSum(int[] nums, int target) {
//    // code here
//    int[][] dp = new int[nums.length + 1][target + 1];
//
//    for(int i=0; i< dp[0].length; i++) {
//        dp[nums.length][i] = 0;
//    }
//
//    dp[nums.length][target] = 1;
//
//    for(int i=nums.length -1; i>=0; i--) {
//        for(int j = target; j>=0; j--) {
//            int pick =0;
//            if(j + nums[i] <= target) {
//                pick = dp[i+1][j + nums[i]];
//            }
//
//            int notPick = dp[i+1][j];
//
//            dp[i][j] = pick + notPick;
//        }
//    }
//
//    return dp[0][0];
//}


//public int perfectSum(int[] nums, int target) {
//    // code here
//    int[][] dp = new int[nums.length + 1][target + 1];
//    for(int[] rows: dp) {
//        Arrays.fill(rows, -1);
//    }
//    return rec(0, 0 , nums,target, dp);
//}
//
//int rec(int i, int sum , int[] nums, int target, int[][] dp) {
//    if(i== nums.length) {
//        if(sum ==  target) {
//            return 1;
//        }
//        return 0;
//    }
//
//    if(dp[i][sum] != -1) {
//        return dp[i][sum];
//    }
//
//    int pick = 0;
//
//    if(sum + nums[i] <= target) {
//        pick = rec(i+1, sum + nums[i], nums, target, dp);
//    }
//
//    int notPick = rec(i+1, sum, nums, target, dp);
//
//    return dp[i][sum] = pick + notPick;
//}

//TC : O(n* targetSum)
//SC  : O(n* targetSum) + O(n)

//public int perfectSum(int[] nums, int target) {
//    // code here
//
//    return rec(0, 0 , nums,target);
//}
//
//int rec(int i, int sum , int[] nums, int target) {
//    if(i== nums.length) {
//        if(sum ==  target) {
//            return 1;
//        }
//        return 0;
//    }
//
//    int pick = 0;
//
//    if(sum + nums[i] <= target) {
//        pick = rec(i+1, sum + nums[i], nums, target);
//    }
//
//    int notPick = rec(i+1, sum, nums, target);
//
//    return pick + notPick;
//}

//TC : O(2^n)
//SC : O(n)