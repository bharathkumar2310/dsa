package dsa.stack;

public class L17_Celebrity_Problem {
    public int celebrity(int mat[][]) {
        // code here
        int start = 0;
        int end = mat.length - 1;

        while(start< end) {

            if(mat[start][end] == 1 ) {
                start++;
            }
            else if(mat[end][start] == 1) {
                end--;
            }
            else {
                start++;
                end--;
            }

        }
        if(start > end) {
            return -1;
        }
        for(int i=0; i<mat.length; i++) {
            if(i!=start) {
                if(mat[start][i] != 0 || mat[i][start] != 1) {
                    return -1;
                }
            }
        }
        return start;
    }
}

//TC : O(n/2 + n) == O(n)
//SC : O(1)