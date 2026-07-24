package dsa.BinarySearchProg;

public class L25_Search_In_A_2D_Matrix_2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix[0].length - 1;

        while(start < matrix.length && end>= 0) {
            if(matrix[start][end] == target) {
                return true;
            }
            else if(matrix[start][end] > target) {
                end--;
            }
            else {
                start++;
            }
        }
        return false;
    }
}

//TC : O(n + m)
//SC : O(1)