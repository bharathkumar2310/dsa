package dsa.recursion;

import java.util.ArrayList;

class L19_Rat_In_A_Maze {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder ans1 = new StringBuilder();
        String DLRU = "DLRU";
        int[] row = {1,0,0,-1};
        int[] col = {0,-1,1,0};
        int[][] vis = new int[maze.length][maze.length];
        vis[0][0] = 1;
        rec(0, 0, maze, ans, DLRU, row, col, vis, ans1);
        return ans;
    }

    void rec(int i, int j, int[][] maze, ArrayList<String>ans, String dir, int[] row, int[] col, int[][] vis, StringBuilder ans1) {

        if(i== maze.length - 1 && j == maze.length - 1) {
            ans.add(ans1.toString());
        }


        for(int k=0; k<4; k++) {
            int nrow = row[k] + i;
            int ncol = col[k] + j;

            if(nrow>=0 && nrow<maze.length && ncol>=0 && ncol<maze.length && maze[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                vis[nrow][ncol] = 1;
                ans1.append(dir.charAt(k));
                rec(nrow, ncol, maze, ans, dir, row, col, vis, ans1);
                ans1.deleteCharAt(ans1.length()-1);
                vis[nrow][ncol] = 0;

            }
        }
    }
}