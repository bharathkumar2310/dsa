package dsa.BinarySearchProg;
// smallest index greater than or equal to target

class L2_Lower_Bound {
    int lowerBound(int[] nums, int target) {
        // code here
        int ans = (int)1e9;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] >= target) {
                ans = Math.min(ans, mid);
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans < nums.length ? ans : nums.length;
    }
}
// can return start also

//TC : O(logn)
//SC : O(1)
