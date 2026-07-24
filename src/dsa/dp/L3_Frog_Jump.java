package dsa.dp;

public class L3_Frog_Jump {
    int minCost(int[] height) {
        // code here
        int next = 0;
        int next1 = 0;
        for(int i = height.length - 2; i>=0; i-- ) {
            int oneStep = Math.abs(height[i+1] - height[i]) + next;
            int twoStep = (int)1e9;
            if(i+2 <= height.length -1) {
                twoStep = Math.abs(height[i+2] - height[i]) + next1;
            }

            int curr = Math.min(oneStep, twoStep);
            next1 = next;
            next = curr;
        }
        return next;
    }
}

//TC : O(n)
//SC : O(1)



//int minCost(int[] height) {
//    // code here
//    int[] dp = new int[height.length + 1];
//    for(int i = height.length - 2; i>=0; i-- ) {
//        int oneStep = Math.abs(height[i+1] - height[i]) + dp[i+1];
//        int twoStep = (int)1e9;
//        if(i+2 <= height.length -1) {
//            twoStep = Math.abs(height[i+2] - height[i]) + dp[i+2];
//        }
//
//        dp[i] = Math.min(oneStep, twoStep);
//    }
//    return dp[0];
//}


//TC : O(n)
//SC : O(n)



//int minCost(int[] height) {
//    // code here
//    int[] dp = new int[height.length];
//    Arrays.fill(dp, -1);
//    return rec(0, height, dp);
//}
//
//int rec(int i, int[] height, int[] dp) {
//    if(i== height.length - 1) {
//        return 0;
//    }
//
//    if(dp[i] != -1) {
//        return dp[i];
//    }
//
//    int oneStep = Math.abs(height[i+1] - height[i]) + rec(i+1, height, dp);
//    int twoStep = (int)1e9;
//    if(i+2 <= height.length -1) {
//        twoStep = Math.abs(height[i+2] - height[i]) + rec(i+2, height, dp);
//    }
//
//    return dp[i] = Math.min(oneStep, twoStep);
//}


//TC : O(n)
//SC : O(2n)



//int minCost(int[] height) {
//    // code here
//    return rec(0, height);
//}
//
//int rec(int i, int[] height) {
//    if(i== height.length - 1) {
//        return 0;
//    }
//
//    int oneStep = Math.abs(height[i+1] - height[i]) + rec(i+1, height);
//    int twoStep = (int)1e9;
//    if(i+2 <= height.length -1) {
//        twoStep = Math.abs(height[i+2] - height[i]) + rec(i+2, height);
//    }
//
//    return Math.min(oneStep, twoStep);
//}

//TC : O(2^n)
//SC : O(n)