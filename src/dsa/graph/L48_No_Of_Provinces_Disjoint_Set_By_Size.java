package dsa.graph;

public class L48_No_Of_Provinces_Disjoint_Set_By_Size {
    int findParent(int[] parent, int ind) {
        if(parent[ind] == ind) {
            return parent[ind];
        }

        return parent[ind] = findParent(parent, parent[ind]);
    }

    public int findCircleNum(int[][] isConnected) {

        int[] parent = new int[isConnected.length];
        int[] size = new int[isConnected.length];
        for(int i=0; i< isConnected.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0; i<isConnected.length; i++) {
            for(int j=0;j<isConnected.length; j++) {
                if(i!=j && isConnected[i][j] == 1) {
                    int parOfI= findParent(parent, i);
                    int parOfJ = findParent(parent, j);

                    if(parOfI == parOfJ) {
                        continue;
                    }

                    if(size[parOfI] >= size[parOfJ]) {
                        parent[parOfJ] = parOfI;
                        size[parOfI] += size[parOfJ];

                    }

                    else if(size[parOfI] < size[parOfJ]) {
                        parent[parOfI] = parOfJ;
                        size[parOfJ] += size[parOfI];
                    }
                }
            }
        }

        int ans = 0;
        for(int i=0; i<parent.length; i++) {
            if(parent[i] == i) {
                ans++;
            }
        }

        return ans;
    }
}

//TC : O(n^2)
//SC : O(n)