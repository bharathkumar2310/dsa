package dsa.recursion;

class L15_Sudoko_Solver {
    public void solveSudoku(int[][] mat) {
        // code here
        int n = 9;
        int m = 9;
        solve(mat);
    }

    boolean solve(int[][] mat) {
        for(int row =0;row<9; row++) {
            for(int col =0; col<9; col++) {
                if(mat[row][col] == 0) {
                    for(int k=1 ; k<=9; k++) {
                        if(isSafe(mat, k,row, col)) {
                            mat[row][col] = k;
                            if(solve(mat) == true) {
                                return true;
                            }
                            mat[row][col] = 0;
                        }

                    }
                    return false;
                }
            }

        }
        return true;
    }


    boolean isSafe(int[][] mat, int k, int row, int col) {
        for(int i=0; i<9; i++) {
            if(mat[row][i] == k || mat[i][col] == k) {
                return false;
            }

            if(mat[3 * (row/3) + i/3][3 * (col/3) + i%3] == k) {
                return false;
            }
        }

        return true;


    }
}
