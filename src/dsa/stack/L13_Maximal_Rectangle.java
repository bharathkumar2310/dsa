package dsa.stack;

import java.util.Stack;

public class L13_Maximal_Rectangle {

    static int maxArea(int mat[][]) {
        // code here

        for(int i=1; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] != 0) {
                    mat[i][j] += mat[i-1][j];
                }
            }
        }
        int ans = 0;
        for(int i=0; i<mat.length; i++) {
            ans = Math.max(ans, largestRectangleArea(mat[i]));
        }
        return ans;

    }

    public static int largestRectangleArea(int[] heights) {
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

//TC : O(row * col) + O(row * col) == O(row * col)
//SC : O(col)