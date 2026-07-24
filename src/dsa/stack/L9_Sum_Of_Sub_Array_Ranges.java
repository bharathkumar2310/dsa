package dsa.stack;

import java.util.Stack;

public class L9_Sum_Of_Sub_Array_Ranges {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] lse = new int[n];
        int[] rse = new int[n];
        int[] lle = new int[n];
        int[] rle = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                int ind = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                lse[ind] = left;
                rse[ind] = i;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int ind = st.pop();
            int left = st.isEmpty() ? -1 : st.peek();
            lse[ind] = left;
            rse[ind] = n;
        }

        for(int i=n - 1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                int ind = st.pop();
                int right = st.isEmpty() ? n : st.peek();
                lle[ind] = i;
                rle[ind] = right;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int ind = st.pop();
            int right = st.isEmpty() ? n : st.peek();
            lle[ind] = -1;
            rle[ind] = right;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            long minCount =
                    (long)(i - lse[i]) *
                            (rse[i] - i);

            long maxCount =
                    (long)(i - lle[i]) *
                            (rle[i] - i);

            ans += maxCount * nums[i];
            ans -= minCount * nums[i];
        }
        return ans;

    }
}

//TC : O(2n + 2n + n) = O(n)
//SC : O(n + 4n) = O(n)

// if the array contains duplicate elements we need to create seperate for loops for
//lse,rse,lle,rle because for lse it should be <nums[i] and for rse it shoyuld be >= or vice versa
// similarly for lle and rle also