package dsa.Arrays;

public class L28_Maximum_Product_SubArray {

    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;
        int pre = 1;
        int suff = 1;

        for (int i = 0; i < nums.length; i++) {
            pre = pre * nums[i];
            suff = suff * nums[nums.length - 1 - i];
            max = Math.max(max, Math.max(pre, suff));
            if (pre == 0) {
                pre = 1;
            }
            if (suff == 0) {
                suff = 1;
            }

        }
        return max;
    }
}

//TC : O(n)
//SC : O(1)