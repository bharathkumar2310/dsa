package dsa.graph;

import java.util.HashSet;
import java.util.Set;

public class L52_Making_A_Large_Island {
    public int largestIsland(int[][] grid) {
        int n = grid.length * grid.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        int ans = 0;
        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] row = {-1,1,0,0};
        int[] col = {0,0,-1,1};

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int ind1 = (grid.length * i) + j;

                    for(int k=0; k<4; k++) {
                        int nRow = row[k] + i;
                        int nCol = col[k] + j;

                        if(isValid(nRow, nCol, grid)) {
                            int ind = (grid.length * nRow) + nCol;
                            if(grid[nRow][nCol] == 1) {
                                union(parent, size, ind, ind1);
                            }

                        }
                    }

                }

            }
        }


        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                int ans1 = 0;
                Set<Integer> set = new HashSet<>();
                if(grid[i][j] == 0) {
                    int ind1 = (grid.length * i) + j;

                    for(int k=0; k<4; k++) {
                        int nRow = row[k] + i;
                        int nCol = col[k] + j;

                        if(isValid(nRow, nCol, grid)) {
                            int ind = (grid.length * nRow) + nCol;
                            if(grid[nRow][nCol] == 1 ) {
                                set.add(findParent(ind, parent));
                            }

                        }
                    }

                }

                for(Integer it : set) {
                    ans1 += size[it];
                }
                ans = Math.max(ans, 1+ans1);
                set.clear();
            }
        }


        for(int i=0; i<n; i++) {
            ans = Math.max(ans, size[i]);
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
        return row>=0 && col>=0 && row<grid.length && col<grid.length;
    }
}

//TC : O(n^2)
//SC : O(n^2)