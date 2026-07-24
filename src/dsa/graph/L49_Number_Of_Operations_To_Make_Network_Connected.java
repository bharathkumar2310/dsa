package dsa.graph;

public class L49_Number_Of_Operations_To_Make_Network_Connected {
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int[] size = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int extraEdge = union(connections, parent, size);
        int totalNoOfComponents = 0;
        for(int i=0; i<n; i++) {
            if(findParent(parent, i) == i) {
                totalNoOfComponents++;
            }
        }

        if(totalNoOfComponents - 1 <= extraEdge) {
            return totalNoOfComponents - 1;
        }

        return -1;

    }



    int union(int[][] connections, int[] parent, int[] size) {

        int extraEdge = 0;
        for(int i=0; i<connections.length; i++) {
            int par1 = findParent(parent, connections[i][0]);
            int par2 = findParent(parent, connections[i][1]);

            if(par1 == par2) {
                extraEdge++;
                continue;
            }

            if(size[par1] >= size[par2]) {
                parent[par2] = par1;
                size[par1] += size[par2];
            } else {
                parent[par1] = par2;
                size[par2] += size[par1];
            }

        }

        return extraEdge;
    }

    int findParent(int[] parent, int ind) {
        if(parent[ind] == ind) {
            return parent[ind];
        }

        return parent[ind] = findParent(parent, parent[ind]);
    }
}

//TC : O(n^2)
//SC : O(n)