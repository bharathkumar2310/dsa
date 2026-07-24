package dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class L9_Flood_Fill {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        int[][] vis = new int[image.length][image[0].length];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        vis[sr][sc] = 1;
        int  startColor = image[sr][sc];
        image[sr][sc] = color;

        int[] rowInd = {-1,1,0,0};
        int[] colInd = {0,0,-1, 1};

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int row = pair.row;
            int col = pair.col;

            for(int i=0; i<rowInd.length; i++) {
                int nRow = row + rowInd[i];
                int nCol = col + colInd[i];
                if(nRow >= 0 && nRow<image.length && nCol >= 0 && nCol < image[0].length && image[nRow][nCol] == startColor && vis[nRow][nCol] == 0) {
                    image[nRow][nCol] = color;
                    vis[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }

            }

        }

        return image;

    }
}


//TC : O(R*C)
//SC : O(R*C)
