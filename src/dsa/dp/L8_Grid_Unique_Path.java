package dsa.dp;

//Same as L9_Grid_Unique_Path_2 without obstacle
public class L8_Grid_Unique_Path {
    public int uniquePaths(int m, int n) {
        return rec(1,1, m,n);
    }

    int rec(int i, int j , int m, int n) {


        if(i==m && j==n) {
            return 1;
        }


        int right = 0;
        if(j+1<=n) {
            right= rec(i, j+1, m, n);

        }
        int down = 0;

        if(i+1<= m) {
            down = rec(i+1, j, m,n);
        }

        return right + down;
    }
}


//TC : O(2^(m+n))
//SC : O(m+n)