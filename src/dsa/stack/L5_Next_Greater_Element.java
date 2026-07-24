package dsa.stack;

import java.util.ArrayList;
import java.util.Stack;

public class L5_Next_Greater_Element {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(arr.length);

        for(int i = 0; i < arr.length; i++) {
            ans.add(-1);
        }

        for(int i=arr.length -1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                ans.set(i, -1);
            } else {
                ans.set(i, arr[st.peek()]);
            }

            st.push(i);
        }
        return ans;
    }
}


//TC : O(2n)
//SC : O(n)