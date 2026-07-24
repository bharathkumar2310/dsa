package dsa.dp;

public class L54_Partition_Array_For_Max_Sum {
    public int maxPartitionSum(int[] arr, int k) {
        // code here
        int[] dp = new int[arr.length + 1];
        for(int i= arr.length -1; i>=0; i--) {
            int ans = 0;

            for(int ind = i; ind < Math.min(arr.length, i + k); ind ++) {

                int ans1 = findMax(i, ind, arr) * (ind - i + 1) + dp[ind + 1];
                ans = Math.max(ans, ans1);
            }
            dp[i] = ans;
        }
        return dp[0];
    }


    int findMax(int i ,int j,  int[] arr) {
        int ans = 0;
        for(int k =i; k<=j; k++) {
            if(ans < arr[k]) {
                ans = arr[k];
            }
        }
        return ans;
    }
}

//TC : O(n * k)
//SC : O(n)

//public int maxPartitionSum(int[] arr, int k) {
//    // code here
//    int[] dp = new int[arr.length];
//    Arrays.fill(dp, -1);
//    return rec(arr, k, 0, dp);
//}
//
//int rec(int[] arr, int k, int i, int[] dp) {
//
//    if(i > arr.length -1) {
//        return 0;
//    }
//
//    int ans = 0;
//
//    if(dp[i] != -1) {
//        return dp[i];
//    }
//
//
//    for(int ind = i; ind < Math.min(arr.length, i + k); ind ++) {
//
//        int ans1 = findMax(i, ind, arr) * (ind - i + 1) + rec(arr, k ,ind + 1, dp);
//        ans = Math.max(ans, ans1);
//    }
//
//    return dp[i] =  ans;
//}
//
//
//int findMax(int i ,int j,  int[] arr) {
//    int ans = 0;
//    for(int k =i; k<=j; k++) {
//        if(ans < arr[k]) {
//            ans = arr[k];
//        }
//    }
//    return ans;
//}

//TC: O(n*k)
//SC : O(n + n)


//public int maxPartitionSum(int[] arr, int k) {
//    // code here
//    return rec(arr, k, 0);
//}
//
//int rec(int[] arr, int k, int i) {
//
//    if(i > arr.length -1) {
//        return 0;
//    }
//
//    int ans = 0;
//
//
//    for(int ind = i; ind < Math.min(arr.length, i + k); ind ++) {
//
//        int ans1 = findMax(i, ind, arr) * (ind - i + 1) + rec(arr, k ,ind + 1);
//        ans = Math.max(ans, ans1);
//    }
//
//    return ans;
//}
//
//
//int findMax(int i ,int j,  int[] arr) {
//    int ans = 0;
//    for(int k =i; k<=j; k++) {
//        if(ans < arr[k]) {
//            ans = arr[k];
//        }
//    }
//    return ans;
//}

//TC : O(k^n)
//SC : O(n)