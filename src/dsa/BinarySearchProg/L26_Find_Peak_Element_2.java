package dsa.BinarySearchProg;

public class L26_Find_Peak_Element_2 {

    public int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat[0].length -1;

        while(start <= end) {
            int mid = (start + end) / 2;
            int max = findMax(mat, mid);
            int left = mid-1>=0 ? mat[max][mid-1] : -1;
            int right = mid + 1<mat[0].length ? mat[max][mid + 1] : -1;
            if((mat[max][mid] > left) && (mat[max][mid] > right)) {
                return new int[] {max, mid};
            }
            else if(mat[max][mid] > left) {
                start = mid + 1;
            }
            else{
                end = mid -1;
            }
        }
        return new int[] {-1, -1};
    }

    int findMax(int[][] mat, int mid) {
        int max = -(int)1e9;
        int row = 0;
        for(int i=0; i<mat.length; i++) {
            if(mat[i][mid] > max) {
                max = mat[i][mid];
                row = i;
            }

        }
        return row;
    }
}

//TC : O(mlogn)
//SC : O(1)
