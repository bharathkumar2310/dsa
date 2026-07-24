package dsa.graph;

import java.util.*;

public class L51_No_Of_Islands_1 {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        int n = rows * cols;
        int[] parent= new int[n];
        int[] size = new int[n];
        int[][] grid = new int[rows][cols];

        int[] row = {-1,1,0,0};
        int[] col = {0,0,-1,1};


        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        List<Integer> ans = new ArrayList<>();
        int ans1 = 0;

        for(int i=0; i< operators.length; i++) {
            int first = operators[i][0];
            int second = operators[i][1];

            if(grid[first][second] == 1){
                ans.add(ans1);
                continue;
            }

            int index = cols * first + second;
            grid[first][second] = 1;
            ans1++;

            for(int k=0; k<4; k++) {
                int nRow = row[k] + first;
                int nCol = col[k] + second;

                if(isValid(nRow, nCol, grid)) {
                    int index1 = cols * nRow + nCol;
                    if(grid[nRow][nCol] == 1) {
                        if(findParent(index,parent) != findParent(index1, parent)) {
                            union(parent, size, index, index1);
                            ans1--;
                        }
                    }
                }

            }

            ans.add(ans1);

        }

        return ans;
    }

    public void union(int[] parent,int[] size, int i , int j) {
        int upI = findParent(i, parent);
        int upJ = findParent(j, parent);

        if(upI == upJ) {
            return;
        }

        if(size[upI] >= size[upJ]) {
            parent[upJ] = upI;
            size[upI] += size[upJ];
        } else {
            parent[upI] = upJ;
            size[upJ] += size[upI];
        }
    }

    public int findParent(int i, int[] parent) {
        if(parent[i] == i) {
            return parent[i];
        }

        return parent[i] = findParent(parent[i], parent);
    }

    public boolean isValid(int row, int col, int[][] grid) {
        return row>=0 && col>=0 && row<grid.length && col<grid[0].length;
    }
}

//TC : O(operators.length)
//SC : O(N^2)

//
//Treat each land cell as a DSU node; whenever a new land is added, assume it forms a new island (count++).
//Check all 4 neighboring land cells; if a neighbor belongs to a different component, union them and decrement the island count.
//If the same cell is added again, ignore it; after each operation, store the current island count.