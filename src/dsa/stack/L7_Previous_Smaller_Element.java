package dsa.stack;

import java.util.ArrayList;
import java.util.Stack;

public class L7_Previous_Smaller_Element {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i= 0 ; i<arr.length; i++) {

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                ans.add(-1);
            }
            else {
                ans.add(arr[st.peek()]);
            }
            st.add(i);
        }
        return ans;

    }
}

//TC : O(2n)
//SC : O(n)
