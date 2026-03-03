package dsa.Arrays;

// KADANE'S ALGORITHM
public class L8_Max_SubArray_Sum {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = -(int)1e9;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            ans = Math.max(sum, ans);
            if(sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}

//TC : O(n)
//SC : O(1)


// worst case
//public int maxSubArray(int[] nums) {
//    int ans = -(int)1e9;
//    for(int i=0; i<nums.length; i++) {
//        int sum = 0;
//        for(int j=i; j<nums.length; j++) {
//            sum += nums[j];
//            if(sum > ans) {
//                ans = sum;
//            }
//        }
//    }
//    return ans;
//}

//TC : O(n^2)
//SC : O(1)
