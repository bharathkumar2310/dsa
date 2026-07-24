package dsa.BinarySearchProg;

import java.util.Arrays;

public class L18_Book_Allocation {
    public int findPages(int[] arr, int k) {
        // code here
        if(k > arr.length) {
            return -1;
        }
        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();
        int ans = Integer.MAX_VALUE;
        while(start <= end) {
            int mid =  (start + end) / 2;
            int ans1 = func(mid, arr);

            if(ans1 <= k) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

    int func(int mid, int[] arr) {
        int count  = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(sum + arr[i] <= mid) {
                sum += arr[i];
            }
            else {
                sum = arr[i];
                count++;
            }
        }
        count++;
        return count;
    }
}

//TC : O(nlogn)
//SC : O(1)
