package dsa.slidingWindow2pointer;

class L4_Longest_Consecutive_Ones {
    public int longestOnes(int[] nums, int k) {
        int temp = 0;
        int left = 0;
        int right = 0;
        int ans =0 ;

        while(right < nums.length) {
            if(nums[right] == 0) {
                temp++;
            }
            if(temp > k) {
                if(nums[left] == 0) {
                    temp--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}

//TC : O(n)
//SC : O(1)