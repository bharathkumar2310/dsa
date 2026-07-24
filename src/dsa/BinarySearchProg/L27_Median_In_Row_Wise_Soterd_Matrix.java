package dsa.BinarySearchProg;

public class L27_Median_In_Row_Wise_Soterd_Matrix {
    public int median(int[][] mat) {
        // code here
        int start = (int)1e9;
        int end= -(int)1e9;

        for(int i = 0; i < mat.length; i++) {
            start = Math.min(start, mat[i][0]);
            end = Math.max(end, mat[i][mat[0].length - 1]);
        }

        int req = (mat.length * mat[0].length) / 2;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(func(mid,  mat) <= req) {
                start = mid + 1;
            }
            else {
                end = mid -1;
            }
        }
        return start;
    }


    int func(int mid, int[][] mat ) {
        int cnt = 0;
        for(int i=0; i<mat.length;i++) {
            cnt += ub(mid, mat[i]);
        }
        return cnt;
    }

    int ub(int val, int[] mat) {
        int start = 0;
        int end = mat.length - 1;
        int ans = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(mat[mid] <= val) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            }
            else {
                end = mid -1;
            }
        }
        return ans + 1;

    }
}

//R = rows
//C = cols
//range = max-min
//TC  : O(log(range) * R * log(C))
//SC : O(1)