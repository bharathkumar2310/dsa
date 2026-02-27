package dsa.slidingWindow2pointer;
//same as L9 ---> consider odd as 0 and even as 1 change conditions alone
class L10_Count_No_Of_Nice_Sub_Arrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return findSubarraySumLessThanSum(nums, k) - findSubarraySumLessThanSum(nums, k - 1);

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
            if(nums[right] %2 == 1) {
                sum+=1;
            }
            while(sum > goal) {
                if(nums[left] %2 == 1) {
                    sum-=1;
                }

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