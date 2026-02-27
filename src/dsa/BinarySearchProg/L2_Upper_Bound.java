package dsa.BinarySearchProg;
// smallest index greater than target
public class L2_Upper_Bound {
    int upperBound(int[] nums, int target) {
        // code here
        int ans = (int)1e9;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] > target) {
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

//TC : O(logn)
//SC : O(1)