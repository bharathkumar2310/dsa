package dsa.dp;

public class L2_Climbing_Stairs {
    public int climbStairs(int n) {

        int prev = 1;
        int prev1 = 0;

        for(int i=1; i<= n; i++) {
            int oneStep =  prev;
            int twoStep = 0;
            if(i-2 >= 0) {
                twoStep =  prev1;
            }

            int curr = oneStep + twoStep;
            prev1 = prev;
            prev = curr;

        }
        return prev;
    }
}


//TC : O(N)
//SC : O(1)

//public int climbStairs(int n) {
//
//    int[] dp = new int[n+1];
//    dp[0] = 1;
//
//    for(int i=1; i< dp.length; i++) {
//        int oneStep =  dp[i-1];
//        int twoStep = 0;
//        if(i-2 >= 0) {
//            twoStep =  dp[i-2];
//        }
//
//        dp[i] = oneStep + twoStep;
//    }
//    return dp[n];
//}


//TC : O(N)
//SC : O(N)


//public int climbStairs(int n) {
//
//    int[] dp = new int[n+1];
//    Arrays.fill(dp, -1);
//    return rec(n, dp);
//}
//
//int rec(int n, int[] dp) {
//    if(n == 0) {
//        return 1;
//    }
//
//    if(dp[n] != -1) {
//        return dp[n];
//    }
//
//    int oneStep =  rec(n-1, dp);
//    int twoStep = 0;
//    if(n-2 >= 0) {
//        twoStep =  rec(n-2, dp);
//    }
//
//    return dp[n] = oneStep + twoStep;
//}


//TC : O(N)
//SC : O(2n)


//public int climbStairs(int n) {
//    return rec(n);
//}
//
//int rec(int n) {
//    if(n == 0) {
//        return 1;
//    }
//
//    int oneStep =  rec(n-1);
//    int twoStep = 0;
//    if(n-2 >= 0) {
//        twoStep =  rec(n-2);
//    }
//
//    return oneStep + twoStep;
//}

//TC : O(2^n)
//SC : O(n)