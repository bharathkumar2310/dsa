package dsa.dp;

public class L16_Partition_A_Set_Into_Subset_With_Min_Abs_Diff {
    public int minDifference(int arr[]) {
        // code here

        int totalSum = 0;
        for(int i=0; i<arr.length; i++) {
            totalSum += arr[i];
        }
        int[] next = new int[totalSum + 1];

        for(int sum=0; sum<next.length; sum++) {
            next[sum] =  Math.abs(sum - (totalSum - sum));
        }

        for(int i = arr.length -1; i>=0;i--) {
            int[] curr = new int[totalSum + 1];
            for(int sum = totalSum; sum>=0;sum-- ) {

                int pick = totalSum;
                if(sum + arr[i] <= totalSum) {
                    pick = next[sum+arr[i]];
                }

                int notPick = next[sum];

                curr[sum] = Math.min(pick, notPick);
            }
            next =curr;
        }



        return next[0];
    }

}

//TC : O(n*sum)
//SC : O(sum)

//public int minDifference(int arr[]) {
//    // code here
//
//    int totalSum = 0;
//    for(int i=0; i<arr.length; i++) {
//        totalSum += arr[i];
//    }
//    int[][] dp = new int[arr.length + 1][totalSum + 1];
//
//    for(int sum=0; sum<dp[0].length; sum++) {
//        dp[arr.length][sum] =  Math.abs(sum - (totalSum - sum));
//    }
//
//    for(int i = arr.length -1; i>=0;i--) {
//        for(int sum = totalSum; sum>=0;sum-- ) {
//
//            int pick = totalSum;
//            if(sum + arr[i] <= totalSum) {
//                pick = dp[i+1][sum+arr[i]];
//            }
//
//            int notPick = dp[i + 1][sum];
//
//            dp[i][sum] = Math.min(pick, notPick);
//        }
//    }
//
//
//
//    return dp[0][0];
//}
//TC : O(n* sum)
//SC : O(n*sum )




//public int minDifference(int arr[]) {
//    // code here
//
//    int totalSum = 0;
//    for(int i=0; i<arr.length; i++) {
//        totalSum += arr[i];
//    }
//    int[][] dp = new int[arr.length][totalSum + 1];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, -1);
//    }
//    return rec(0, 0, totalSum, arr, dp);
//}
//
//
//int rec(int i, int sum , int totalSum, int[] arr, int[][] dp) {
//    if(i == arr.length) {
//        return Math.abs(sum - (totalSum - sum));
//
//    }
//
//    if(dp[i][sum] != -1) {
//        return dp[i][sum];
//    }
//
//
//    int pick = rec(i+1, sum+arr[i], totalSum, arr, dp);
//    int notPick = rec(i + 1, sum, totalSum, arr, dp);
//
//    return dp[i][sum] = Math.min(pick, notPick);
//}

//TC : O(n* sum)
//SC : O(n*sum + n)


//public int minDifference(int arr[]) {
//    // code here
//
//    int totalSum = 0;
//    for(int i=0; i<arr.length; i++) {
//        totalSum += arr[i];
//    }
//
//    return rec(0, 0, totalSum, arr);
//}
//
//
//int rec(int i, int sum , int totalSum, int[] arr) {
//    if(i == arr.length) {
//        return Math.abs(sum - (totalSum - sum));
//
//    }
//
//
//    int pick = rec(i+1, sum+arr[i], totalSum, arr);
//    int notPick = rec(i + 1, sum, totalSum, arr);
//
//    return Math.min(pick, notPick);
//}

//TC : O(2^n)
//SC : O(n)