package dsa.Arrays;

import java.util.ArrayList;
import java.util.List;

public class L16_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        List<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
            }
            bottom--;

            if (right >= left) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
            }
            left++;
        }
        return ans;
    }
}

//TC : O(m*n) where m is the number of rows and n is the number of columns
//SC : O(m*n) for the answer list
