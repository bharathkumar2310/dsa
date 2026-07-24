package dsa.dp;

//Same as L18_Count_Partitions_With_Given_Difference
public class L21_Target_Sum {

    public int totalWays(int[] arr, int target) {
        // code here

        return countPartitions(arr, target);

    }
    public int countPartitions(int[] arr, int diff) {
        int xPlusY = 0;
        for(int i=0; i<arr.length; i++) {
            xPlusY += arr[i];
        }
        int xMinusY = diff;

        int twoX = (xPlusY + xMinusY);
        if(twoX % 2 != 0) {
            return 0;
        }

        int x = twoX/2;
        return perfectSum(arr, x);

    }


    int perfectSum(int[] nums, int target) {
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


//TC : O(n * x)
//SC : O(n)



//public int totalWays(int[] arr, int target) {
//    // code here
//    int[][] dp = new int[arr.length + 1][20001];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, -1);
//    }
//    return rec(0, arr, target, dp);
//}
//
//int rec(int i, int[] arr, int target, int[][] dp) {
//
//    if (i == arr.length) {
//        return target == 0 ? 1 : 0;
//    }
//
//    if(dp[i][target + 1000] != -1) {
//        return dp[i][target + 1000];
//    }
//
//    int add = rec(i+1, arr, target - arr[i], dp);
//    int sub  = rec(i+1, arr, target + arr[i], dp);
//
//    return dp[i][target + 1000] = add + sub;
//}


//public int totalWays(int[] arr, int target) {
//    // code here
//    return rec(0, arr, target);
//}
//
//int rec(int i, int[] arr, int target) {
//
//    if (i == arr.length) {
//        return target == 0 ? 1 : 0;
//    }
//
//    int add = rec(i+1, arr, target - arr[i]);
//    int sub  = rec(i+1, arr, target + arr[i]);
//
//    return add + sub;
//}

//TC : O(2^n)
//SC : O(n)