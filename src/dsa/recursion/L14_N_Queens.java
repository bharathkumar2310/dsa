package dsa.recursion;

import java.util.ArrayList;

class L14_N_Queens {

    public ArrayList<ArrayList<Integer>> nQueen(int n) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        boolean[] cols = new boolean[n];
        boolean[] diagDown = new boolean[2 * n - 1]; // row - col + (n - 1)
        boolean[] diagUp = new boolean[2 * n - 1];   // row + col

        backtrack(0, n, result, path, cols, diagDown, diagUp);
        return result;
    }

    private void backtrack(int row, int n, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path,
            boolean[] cols, boolean[] diagDown, boolean[] diagUp) {

        if (row == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < n; col++) {

            int dDown = row - col + (n - 1);
            int dUp = row + col;

            if (cols[col] || diagDown[dDown] || diagUp[dUp]) {
                continue;
            }

            cols[col] = true;
            diagDown[dDown] = true;
            diagUp[dUp] = true;
            path.add(col + 1);

            backtrack(row + 1, n, result, path, cols, diagDown, diagUp);

            cols[col] = false;
            diagDown[dDown] = false;
            diagUp[dUp] = false;
            path.remove(path.size() - 1);
        }
    }
}



//public List<List<String>> solveNQueens(int n) {
//    List<List<String>> ans = new ArrayList<>();
//    boolean[] leftDiag = new boolean[2 * n + 1];
//    boolean[] rightDiag = new boolean[2 * n + 1];
//    boolean[] col = new boolean[n];
//    List<String> ans1 = new ArrayList<>();
//
//    rec(0, ans, leftDiag, rightDiag, col, ans1, n);
//    return ans;
//}
//
//void rec(int i, List<List<String>> ans, boolean[] leftDiag, boolean[] rightDiag, boolean[] col, List<String> ans1, int n) {
//
//    if(i>=n) {
//        ans.add(new ArrayList<>(ans1));
//        return;
//    }
//
//
//    for(int j=0; j<n; j++) {
//        if(leftDiag[j-i + n -1] == false && rightDiag[j+i] == false && col[j] == false) {
//            leftDiag[j-i + n -1]  = true;
//            rightDiag[j+i] = true;
//            col[j] = true;
//            char[] row = new char[n];
//            Arrays.fill(row, '.');
//            row[j] = 'Q';
//            ans1.add(new String(row));
//            rec(i+1, ans, leftDiag, rightDiag, col, ans1, n);
//            leftDiag[j-i + n -1]  = false;
//            rightDiag[j+i] = false;
//            col[j] = false;
//            ans1.remove(ans1.size() -1);
//
//        }
//    }
//}


//TC : O(n * n!) // first row 4 second row 3 third row 2
//SC : O(n)