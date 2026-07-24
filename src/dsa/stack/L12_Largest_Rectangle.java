package dsa.stack;

import java.util.Stack;

public class L12_Largest_Rectangle {

    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int ind = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                ans = Math.max(ans, (i - left -1) * heights[ind]);
            }
            st.add(i);
        }

        while(!st.isEmpty()) {
            int ind = st.pop();
            int left = st.isEmpty() ? -1 : st.peek();
            ans = Math.max(ans, (n - left -1) * heights[ind]);
        }
        return ans;
    }
}

//TC : O(n + n) = O(n)
//SC : O(n)







//public int largestRectangleArea(int[] heights) {
//    int n= heights.length;
//    int[] lse = new int[n];
//    int[] rse = new int[n];
//
//    Stack<Integer> st = new Stack<>();
//
//    for(int i=0; i<n; i++) {
//
//        while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
//            st.pop();
//        }
//
//        if(st.isEmpty()) {
//            lse[i] = -1;
//        } else {
//            lse[i] = st.peek();
//        }
//
//        st.add(i);
//    }
//
//    st.clear();
//
//    for(int i=n-1; i>=0; i--) {
//
//        while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
//            st.pop();
//        }
//
//        if(st.isEmpty()) {
//            rse[i] = n;
//        } else {
//            rse[i] = st.peek();
//        }
//
//        st.add(i);
//    }
//
//    int ans = 0;
//
//    for(int i=0; i<n; i++) {
//
//        ans = Math.max(ans, (rse[i]-lse[i] -1) * heights[i]);
//
//    }
//    return ans;
//}




//TC : O(2n) + O(2n) + O(n) = O(n)
//SC : O(n) + O(n) + O(n) = O(n)
