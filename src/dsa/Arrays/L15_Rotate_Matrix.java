package dsa.Arrays;

public class L15_Rotate_Matrix {
    public void rotate(int[][] matrix) {

        for(int i=0; i<matrix.length; i++) {
            for(int j = i+1; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i= 0; i<matrix.length; i++) {
            reverse(i, matrix);
        }


    }

    public void reverse(int i, int[][] matrix) {
        int j1 = 0;
        int j2 = matrix[i].length -1;
        while(j1 < j2) {
            swap(j1, j2, i, matrix);
            j1++;
            j2--;
        }
    }

    public void swap(int j1, int j2, int i, int[][] matrix) {
        int temp = matrix[i][j1];
        matrix[i][j1] = matrix[i][j2];
        matrix[i][j2] = temp;
    }
}

//TC : O(n^2 + n^2/2) => O(n^2)
//SC : O(1)




//public void rotate(int[][] matrix) {
//    int[][] ans = new int[matrix.length][matrix[0].length];
//    for(int i=0; i<matrix.length; i++) {
//        for(int j=0; j<matrix[0].length; j++) {
//            ans[j][matrix.length - 1 - i] = matrix[i][j];
//        }
//    }
//
//    for(int i=0; i<matrix.length; i++) {
//        for(int j=0; j<matrix[0].length; j++) {
//            matrix[i][j] = ans[i][j];
//        }
//    }
//}

//TC : O(n^2 + n^2) => O(n^2)
//SC : O(n^2)

