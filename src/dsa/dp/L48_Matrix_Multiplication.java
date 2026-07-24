package dsa.dp;

import java.util.Arrays;

public class L48_Matrix_Multiplication {

    static int matrixMultiplication(int arr[]) {
        // code here
        int[][] dp = new int[arr.length][arr.length];


        for(int i=arr.length -1; i>=1; i--) {
            for(int j=i+1; j<arr.length; j++) {
                int ans1 = (int)1e9;
                for(int ind = i; ind<j; ind++) {
                    int ans = (arr[i-1]* arr[ind]* arr[j]) + dp[ind+1][j] + dp[i][ind];
                    ans1 = Math.min(ans, ans1);
                }
                dp[i][j] = ans1;

            }
        }
        return dp[1][arr.length -1];
    }
}

//TC : O(n^3)
//SC : O(n^2)  ===> Stack space is reduced

/// Memoization

//static int matrixMultiplication(int arr[]) {
//    // code here
//    int[][] dp = new int[arr.length][arr.length];
//    for(int[] dp1 : dp) {
//        Arrays.fill(dp1, -1);
//    }
//    return rec(1, arr.length-1, arr, dp);
//}
//
//
//static int rec(int i, int j, int[] arr, int[][] dp) {
//
//    if(i>=j) {
//        return 0;
//    }
//
//    if(dp[i][j] != -1) {
//        return dp[i][j];
//    }
//
//
//    int ans1 = (int) 1e9;
//
//    for(int ind = i; ind<j; ind++) {
//        int ans = (arr[i-1]* arr[ind]* arr[j]) + rec(ind + 1,j, arr, dp) + rec(i, ind, arr, dp);
//        ans1 = Math.min(ans, ans1);
//    }
//
//    return dp[i][j] = ans1;
//}



//TC : O(n^3)
//SC : O(n^2 + n)

// recursion only

//static int matrixMultiplication(int arr[]) {
//    // code here
//    return rec(1, arr.length-1, arr);
//}
//
//
//static int rec(int i, int j, int[] arr) {
//
//    if(i>=j) {
//        return 0;
//    }
//    int ans1 = (int) 1e9;
//
//    for(int ind = i; ind<j; ind++) {
//        int ans = (arr[i-1]* arr[ind]* arr[j]) + rec(ind + 1,j, arr) + rec(i, ind, arr);
//        ans1 = Math.min(ans, ans1);
//    }
//
//    return ans1;
//}

//TC : O(2^n) ===> not accurstely (usually some exponentially)
//SC : O(n) ===> for stack space