package dsa.Arrays;

public class L14_Set_Matrix_Zero {
    public void setZeroes(int[][] matrix) {
        int row0 = 1;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(i==0 && matrix[i][j] == 0) {
                    row0 = 0;
                }
                else if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j=1; j<matrix[0].length; j++) {
            if(row0 == 0) {
                matrix[0][j] = 0;
            }
        }

        for(int i=0; i<matrix.length; i++) {
            if(matrix[0][0] == 0) {
                matrix[i][0] = 0;
            }
        }

        if(row0 == 0) {
            matrix[0][0] = 0;
        }
    }
}

//TC : O((m*n) + (m*n) + m + n) => O(m*n)
//SC : O(1)

