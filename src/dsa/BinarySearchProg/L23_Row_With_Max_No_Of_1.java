package dsa.BinarySearchProg;

public class L23_Row_With_Max_No_Of_1 {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int ans = Integer.MAX_VALUE;
        int ans1 = -1;
        for(int i=0; i<arr.length; i++) {
            int ans2 = func(arr,i);
            if(ans2 < ans) {
                ans = ans2;
                ans1 = i;
            }
        }
        return ans1;
    }

    int func(int[][] mat, int i) {
        int start = 0;
        int end = mat[0].length - 1;
        int ans = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end)  / 2;
            if(mat[i][mid] == 1 ) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}

//TC : O(nlogn)
//SC : O(1)