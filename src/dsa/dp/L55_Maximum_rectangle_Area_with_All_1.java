package dsa.dp;

import java.util.Stack;

public class L55_Maximum_rectangle_Area_with_All_1 {
    public int maximalRectangle(char[][] matrix) {

        int[] height = new int[matrix[0].length];
        int ans = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }

            ans = Math.max(ans, histogram(height));
        }
        return ans;
    }

    int histogram(int[] height) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int[] pre = new int[height.length];
        Arrays.fill(pre, -1);
        for(int i=0; i<height.length; i++) {

            while(!st.isEmpty() && height[i] <= height[st.peek()]) {
                int ele = st.pop();
                int leftSmall = pre[ele];
                int rightSmall = i;
                ans = Math.max(ans, (rightSmall - leftSmall -1) * height[ele]);
            }


            if(!st.isEmpty()) {
                pre[i] = st.peek();
            }

            st.add(i);
        }

        while(!st.isEmpty()) {
            int ele = st.pop();
            ans = Math.max(ans, (height.length - pre[ele] - 1) * height[ele] );
        }

        return ans;
    }
}
