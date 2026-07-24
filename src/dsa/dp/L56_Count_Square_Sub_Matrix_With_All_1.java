package dsa.dp;

public class L56_Count_Square_Sub_Matrix_With_All_1 {
    public int countSquares(int[][] mat) {
        // code here
        int ans = 0;

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {


                if(i== 0 || j==0) {
                    ans += mat[i][j];
                    continue;
                }
                else {
                    if(mat[i][j] != 0) {
                        mat[i][j] = 1 + Math.min(mat[i-1][j], Math.min(mat[i][j-1], mat[i-1][j-1]));
                        ans += mat[i][j];
                    }
                }
            }
        }

        return ans;
    }
}

//TC : O(n^2)
//SC: O(1)
