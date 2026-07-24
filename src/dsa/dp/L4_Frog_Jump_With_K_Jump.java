package dsa.dp;

public class L4_Frog_Jump_With_K_Jump {
}

//public int frogJump(int[] heights, int k) {
//    int [] dp = new int[heights.length];
//    for(int i = dp.length - 2; i>=0; i--) {
//        int ans = (int)1e9;
//        for(int ind = i + 1; ind<=i+k; ind++) {
//            if(ind <= heights.length -1) {
//                ans = Math.min(ans, Math.abs(heights[ind] - heights[i]) + dp[ind]);
//            }
//        }
//        dp[i] = ans;
//    }
//    return dp[0];
//}


//TC : O(n*k)
//SC : O(n)


//public int frogJump(int[] heights, int k) {
//    int [] dp = new int[heights.length];
//    Arrays.fill(dp, -1);
//    return rec(0, heights, k, dp);
//
//}
//
//int rec(int i, int[] heights , int k, int[] dp) {
//    if(i==heights.length -1) {
//        return 0;
//    }
//    if(dp[i] != -1) {
//        return dp[i];
//    }
//
//
//
//    int ans = (int)1e9;
//    for(int ind = i + 1; ind<=i+k; ind++) {
//        if(ind <= heights.length -1) {
//            ans = Math.min(ans, Math.abs(heights[ind] - heights[i]) + rec(ind, heights, k, dp));
//        }
//    }
//    return dp[i] = ans;
//}


//TC : O(n*k)
//SC : O(2n)


//public int frogJump(int[] heights, int k) {
//    return rec(0, heights, k);
//
//}
//
//int rec(int i, int[] heights , int k) {
//    if(i==heights.length -1) {
//        return 0;
//    }
//    int ans = (int)1e9;
//    for(int ind = i + 1; ind<=i+k; ind++) {
//        if(ind <= heights.length -1) {
//            ans = Math.min(ans, Math.abs(heights[ind] - heights[i]) + rec(ind, heights, k));
//        }
//    }
//    return ans;
//}

//TC : O(k^n)
//SC : O(n)