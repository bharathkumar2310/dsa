package dsa.BinarySearchProg;
// lowerbound

class L2_Find_Ceil {
    public int findCeil(int[] arr, int x) {
        // code here
        return lowerBound(arr, x);
    }
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

        return ans < nums.length ? ans : -1;
    }
}



//TC : O(logn)
//SC : O(1)