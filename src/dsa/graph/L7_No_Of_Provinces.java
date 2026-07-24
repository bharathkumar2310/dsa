package dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class L7_No_Of_Provinces {
    public int findCircleNum(int[][] isConnected) {
        int[] vis = new int[isConnected.length];
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        for(int i=0; i<isConnected.length; i++) {
            if(vis[i] == 0) {
                ans++;
                q.add(i );
                vis[i] = 1;
                while(!q.isEmpty()) {
                    Integer index = q.poll();
                    for(int j=0; j<isConnected[i].length; j++) {
                        if( index!=j && isConnected[index][j] == 1 && vis[j] == 0) {
                            q.add(j);
                            vis[j] = 1;
                        }
                    }
                }

            }
        }

        return ans;
    }
}

//TC : O(V^2)
//SC : O(V)