package dsa.graph;



//Treat each row and each column as separate DSU nodes, and offset column indices so they don't overlap with rows.
//For every stone (r, c), union rowNode and colNode, connecting all stones sharing a row or column into the same component.
//If there are k connected components, one stone must remain in each, so the answer is totalStones - k.

public class L53_Most_Stones_Removed_With_Same_Row_Column {
    public int maxRemove(int[][] stones) {
        // Code here

        int maxRow  = 0;
        int maxCol = 0;

        for(int i=0; i<stones.length; i++) {
            int first = stones[i][0];
            int second = stones[i][1];
            maxRow = Math.max(first, maxRow);
            maxCol = Math.max(second, maxCol);
        }

        int n = maxRow + maxCol + 2;

        int[] parent = new int[n];
        int[] size = new int[n];
        int[] vis = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0; i<stones.length; i++) {
            int first = stones[i][0];
            int second = stones[i][1];
            second = maxRow + second + 1;
            vis[first] = 1;
            vis[second] = 1;
            union(parent, size, first, second);
        }

        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(vis[i] == 1 && findParent(i, parent) == i) {
                cnt++;
            }
        }

        return stones.length - cnt;

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
}

//TC : O(maxRow + maxCol + 2)
//SC : O(maxRow + maxCol + 2)

