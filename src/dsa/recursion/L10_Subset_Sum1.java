package dsa.recursion;

import java.util.ArrayList;

class L10_Subset_Sum1 {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        rec(0, arr, ans, 0);
        return ans;
    }

    void rec(int i, int[] arr, ArrayList<Integer> ans, int sum) {
        if(i == arr.length) {
            ans.add(sum);
            return;
        }
        sum += arr[i];
        rec(i+1, arr,ans, sum);
        sum-=arr[i];
        rec(i+1,arr,ans,sum);
    }
}
