package dsa.dp;

public class L14_SubSet_Sum_Equals_Target {

    static boolean isSubsetSum(int arr[], int sum) {
        // code here

        boolean[] next = new boolean[sum + 1];
        next[sum] = true;

        for(int i= arr.length - 1; i>=0; i--) {
            boolean[] curr = new boolean[sum + 1];
            curr[sum] = true;
            for(int j=sum; j>=0; j--) {
                boolean pick = false;
                if(j + arr[i] <= sum) {
                    pick = next[j + arr[i]];

                }
                boolean notPick = next[j];
                curr[j] = pick || notPick ;
            }
            next = curr;
        }

        return next[0];
    }
}


//TC : O(n* sum)
//SC : O(sum)

//static Boolean isSubsetSum(int arr[], int sum) {
//    // code here
//
//    boolean[][] dp = new boolean[arr.length + 1][sum + 1];
//
//    for(int i=0; i<dp[0].length; i++) {
//        dp[dp.length - 1][i] = false;
//    }
//
//    for(int i=0; i<dp.length; i++) {
//        dp[i][sum] = true;
//    }
//
//    for(int i= arr.length - 1; i>=0; i--) {
//        for(int j=sum; j>=0; j--) {
//            Boolean pick = false;
//            if(j + arr[i] <= sum) {
//                pick = dp[i+1][j + arr[i]];
//
//            }
//            Boolean notPick = dp[i+1][j];
//            dp[i][j] = pick || notPick ;
//        }
//    }
//
//    return dp[0][0];
//}


//TC : O(n* sum)
//SC : O(n*sum )



//static Boolean isSubsetSum(int arr[], int sum) {
//    // code here
//
//    Boolean[][] dp = new Boolean[arr.length][sum + 1];
//    return rec(0, 0, sum, arr, dp);
//}
//
//static Boolean rec(int i, int totalSum, int sum, int[] arr, Boolean[][] dp) {
//
//    if(sum == totalSum) {
//        return true;
//    }
//
//    if(i== arr.length) {
//        return false;
//    }
//
//    if(dp[i][totalSum] != null) {
//        return dp[i][totalSum];
//    }
//
//    Boolean pick = false;
//    if(totalSum + arr[i] <= sum) {
//        pick = rec(i+1, totalSum + arr[i] , sum, arr, dp);
//
//    }
//    Boolean notPick = rec(i+1, totalSum, sum , arr, dp);
//
//
//    return dp[i][totalSum] = pick || notPick ;
//
//
//}


//TC : O(n* sum)
//SC : O(n*sum + n)


//static Boolean isSubsetSum(int arr[], int sum) {
//    // code here
//    return rec(0, 0, sum, arr);
//}
//
//static Boolean rec(int i, int totalSum, int sum, int[] arr) {
//
//    if(sum == totalSum) {
//        return true;
//    }
//
//    if(i== arr.length) {
//        return false;
//    }
//
//    Boolean pick = false;
//    if(totalSum + arr[i] <= sum) {
//        pick = rec(i+1, totalSum + arr[i] , sum, arr);
//
//    }
//    Boolean notPick = rec(i+1, totalSum, sum , arr);
//
//
//    return pick || notPick ;
//
//
//}

//TC : O(2^n)
//SC : O(n)