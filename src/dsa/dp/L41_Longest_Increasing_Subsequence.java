package dsa.dp;

public class L41_Longest_Increasing_Subsequence {
    static int lis(int arr[]) {
        // code here
        int[][] dp = new int[arr.length + 1][arr.length + 1];

        for(int i= arr.length -1; i>=0; i--) {
            for(int j=i-1; j>=-1; j--) {

                int pick = 0;
                int notPick = 0;

                if(j == -1 || arr[i] > arr[j]) {
                    pick = 1 + dp[i+1][i+1];
                }

                notPick = dp[i+1][j+1];

                dp[i][j+1] = Math.max(pick, notPick);
            }
        }

        return dp[0][0];
    }
}

//TC : O(n^2)
//SC : O(n^2)

//static int lis(int arr[]) {
//    // code here
//    int[][] dp = new int[arr.length][arr.length];
//    for(int[] row : dp) {
//        Arrays.fill(row, -1);
//    }
//
//    return rec(0, arr,-1, dp);
//}
//
//
//static int rec(int i, int[] arr, int prevMax, int[][] dp) {
//
//    if(i >= arr.length) {
//        return 0;
//    }
//
//    if(prevMax!=-1 && dp[i][prevMax] != -1) {
//        return dp[i][prevMax];
//    }
//
//    int pick = 0;
//    int notPick = 0;
//
//    if(prevMax == -1 || arr[i] > arr[prevMax]) {
//        pick = 1 + rec(i+1, arr, i, dp);
//    }
//
//    notPick = rec(i+1, arr, prevMax, dp);
//
//    if(prevMax != -1) {
//        dp[i][prevMax] = Math.max(pick, notPick);
//    }
//
//    return Math.max(pick, notPick);
//}

//TC : O(n^2)
//SC : O(n^2 + n)

//static int lis(int arr[]) {
//    // code here
//    return rec(0, arr, -(int)1e9);
//}
//
//
//static int rec(int i, int[] arr, int prevMax) {
//
//    if(i >= arr.length) {
//        return 0;
//    }
//
//    int pick = 0;
//    int notPick = 0;
//
//    if(arr[i] > prevMax) {
//        pick = 1 + rec(i+1, arr, arr[i]);
//    }
//
//    notPick = rec(i+1, arr, prevMax);
//
//    return Math.max(pick, notPick);
//}


//TC : O(2^n)
//SC : O(n)