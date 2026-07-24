package dsa.stack;

import java.util.Stack;

public class L6_Next_greater_Element_2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nums1 = new int[2*n];
        for(int i =0; i<nums1.length; i++) {
            nums1[i] = nums[i%n];
        }
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = nums1.length -1 ; i>=0;i--) {
            while(!st.isEmpty() && nums1[st.peek()] <= nums1[i]) {
                st.pop();
            }

            if(i<n) {
                if(st.isEmpty()) {
                    ans[i] = -1;
                }
                else {
                    ans[i] = nums1[st.peek()];
                }
            }

            st.push(i);
        }
        return ans;
    }
}

//TC : O(2n)
//SC : O(2n + n)