package dsa.BinarySearchProg;

class L2_FindFloor {
    public int findFloor(int[] nums, int target) {
        // code here
        int ans = -(int)1e9;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] <= target) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            }
            else{
                end  = mid - 1;
            }
        }

        return ans >= 0 ? ans : -1;
    }

}


//TC : O(logn)
//SC : O(1)