package dsa.BinarySearchProg;

public class L24_Search_in_2D_Matrix_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = (matrix.length * matrix[0].length) - 1;

        while(start <= end) {
            int mid = (start + end)/ 2;
            if(matrix[mid / matrix[0].length][mid % matrix[0].length] == target) {
                return true;
            }
            else if(matrix[mid / matrix[0].length][mid % matrix[0].length] < target ) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}

//TC : O(nlogn)
//SC : O(1)
