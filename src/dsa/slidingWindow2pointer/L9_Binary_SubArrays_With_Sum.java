package dsa.slidingWindow2pointer;

class L9_Binary_SubArrays_With_Sum {
    public int numSubarraysWithSum(int[] nums, int goal) {

        return findSubarraySumLessThanSum(nums, goal) - findSubarraySumLessThanSum(nums, goal - 1);
    }

    public int findSubarraySumLessThanSum(int[] nums, int goal) {

        if (goal < 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;

        while(right < nums.length) {

            sum += nums[right];

            while(sum > goal) {
                sum= sum-nums[left];
                left++;
            }
            ans += (right - left + 1);
            right++;
        }
        return ans;
    }
}

//TC : O(2 * 2n)
//SC : O(1)