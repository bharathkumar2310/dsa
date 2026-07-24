package dsa.dp;

import java.util.Arrays;

public class L50_Min_Cost_To_Cut_Sticks {
    public int minCutCost(int n, int[] cuts) {
        // code here
        int[] cuts1 = new int[cuts.length + 2];
        cuts1[0] = 0;
        cuts1[cuts1.length - 1] = n;
        for(int i=1; i<cuts1.length-1; i++) {
            cuts1[i] = cuts[i-1];
        }
        Arrays.sort(cuts1);

        int[][] dp = new int[cuts1.length][cuts1.length];
        for(int i= cuts.length; i>0; i--) {
            for(int j= i; j<=cuts.length; j++) {
                int ans1 = (int)1e9;

                for(int ind = i; ind <=j; ind++) {
                    int ans = cuts1[j+1] - cuts1[i-1] + dp[i][ind-1] + dp[ind + 1][j];
                    ans1 = Math.min(ans, ans1);
                }

                dp[i][j] = ans1;
            }
        }

        return dp[1][cuts.length];
    }

}

//TC : O(n^3)
//SC : O(n^2)


//public int minCutCost(int n, int[] cuts) {
//    // code here
//    int[] cuts1 = new int[cuts.length + 2];
//    cuts1[0] = 0;
//    cuts1[cuts1.length - 1] = n;
//    for(int i=1; i<cuts1.length-1; i++) {
//        cuts1[i] = cuts[i-1];
//    }
//    Arrays.sort(cuts1);
//
//    int[][] dp = new int[cuts1.length][cuts1.length];
//    for(int[] dp1 : dp) {
//        Arrays.fill(dp1, -1);
//    }
//
//    return rec(1, cuts.length, cuts1, dp);
//}
//
//static int rec(int i, int j , int[] cuts1, int[][] dp) {
//
//    if(i> j) {
//        return 0;
//    }
//
//    int ans1 = (int)1e9;
//
//    if(dp[i][j] != -1) {
//        return dp[i][j];
//    }
//
//    for(int ind = i; ind <=j; ind++) {
//        int ans = cuts1[j+1] - cuts1[i-1] + rec(i, ind-1, cuts1, dp) + rec(ind +1, j, cuts1, dp);
//        ans1 = Math.min(ans, ans1);
//    }
//
//    return dp[i][j] = ans1;
//}

//TC : O(n^3)
//SC : O(n^2) + O(n)


//public int minCutCost(int n, int[] cuts) {
//    // code here
//    int[] cuts1 = new int[cuts.length + 2];
//    cuts1[0] = 0;
//    cuts1[cuts1.length - 1] = n;
//    for(int i=1; i<cuts1.length-1; i++) {
//        cuts1[i] = cuts[i-1];
//    }
//    Arrays.sort(cuts1);
//
//    return rec(1, cuts.length, cuts1);
//}
//
//static int rec(int i, int j , int[] cuts1) {
//
//    if(i> j) {
//        return 0;
//    }
//
//    int ans1 = (int)1e9;
//
//    for(int ind = i; ind <=j; ind++) {
//        int ans = cuts1[j+1] - cuts1[i-1] + rec(i, ind-1, cuts1) + rec(ind +1, j, cuts1);
//        ans1 = Math.min(ans, ans1);
//    }
//
//    return ans1;
//}
//TC : O(2^n) // more than this can say exponential  4^m / (m^(3/2))
//SC : O(n) //Stack space