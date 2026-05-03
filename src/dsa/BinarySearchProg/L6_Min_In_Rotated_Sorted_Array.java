package dsa.BinarySearchProg;

public class L6_Min_In_Rotated_Sorted_Array {
    public int findMin(int[] arr) {
        // code here
        int start = 0;
        int end = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while(start <= end) {
            int mid  = (start + end) / 2;
            if(arr[mid] >= arr[start]) {
                ans = Math.min(ans, arr[start]);
                start = mid + 1;
            }
            else {
                ans = Math.min(ans,arr[mid]);
                end = mid - 1;
            }
        }
        return ans;
    }
}

//TC : O(logn)
//SC : O(1)