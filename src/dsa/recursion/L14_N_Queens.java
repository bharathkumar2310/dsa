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

