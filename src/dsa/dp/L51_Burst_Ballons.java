package dsa.dp;

public class L51_Burst_Ballons {

    public int maxCoins(int[] nums) {

        int[] nums1 = new int[nums.length + 2];
        nums1[0] = 1;
        nums1[nums1.length - 1] = 1;

        for(int i=1; i<nums1.length -1; i++) {
            nums1[i] = nums[i-1];
        }
        int[][] dp = new int[nums1.length][nums1.length];

        for(int i= nums.length ; i>0; i--) {
            for(int j=i; j<=nums.length; j++) {
                int ans1 = -(int)1e9;

                for(int ind = i; ind <= j ; ind ++) {
                    int ans = nums1[i-1]*nums1[j+1] * nums1[ind] + dp[i][ind-1] + dp[ind+1][j];
                    ans1 = Math.max(ans, ans1);
                }

                dp[i][j] = ans1;
            }
        }

        return dp[1][nums.length];
    }

}

//TC : O(n^3)
//SC : O(n^2)

//public int maxCoins(int[] nums) {
//
//    int[] nums1 = new int[nums.length + 2];
//    nums1[0] = 1;
//    nums1[nums1.length - 1] = 1;
//
//    for(int i=1; i<nums1.length -1; i++) {
//        nums1[i] = nums[i-1];
//    }
//    int[][] dp = new int[nums1.length][nums1.length];
//    for(int[] dp1 : dp) {
//        Arrays.fill(dp1, -1);
//    }
//
//    return rec(1, nums.length, nums1, dp);
//}
//
//static int rec(int i, int j, int[] nums1, int[][] dp) {
//    if(i>j) {
//        return 0;
//    }
//
//    if(dp[i][j] != -1 ) {
//        return dp[i][j];
//    }
//
//    int ans1 = -(int)1e9;
//
//    for(int ind = i; ind <= j ; ind ++) {
//        int ans = nums1[i-1]*nums1[j+1] * nums1[ind] + rec(i, ind-1, nums1, dp) + rec(ind+1, j, nums1, dp);
//        ans1 = Math.max(ans, ans1);
//    }
//
//    return dp[i][j] = ans1;
//}

//TC : O(n^3)
//SC : O(n^2) + O(n)


//public int maxCoins(int[] nums) {
//
//    int[] nums1 = new int[nums.length + 2];
//    nums1[0] = 1;
//    nums1[nums1.length - 1] = 1;
//
//    for(int i=1; i<nums1.length -1; i++) {
//        nums1[i] = nums[i-1];
//    }
//
//    return rec(1, nums.length, nums1);
//}
//
//static int rec(int i, int j, int[] nums1) {
//    if(i>j) {
//        return 0;
//    }
//
//    int ans1 = -(int)1e9;
//
//    for(int ind = i; ind <= j ; ind ++) {
//        int ans = nums1[i-1]*nums1[j+1] * nums1[ind] + rec(i, ind-1, nums1) + rec(ind+1, j, nums1);
//        ans1 = Math.max(ans, ans1);
//    }
//
//    return ans1;
//}

//TC : exponential
//SC : O(n)