package dsa.GFG.puzzle;

public class L1_Count_Perfect_Squares {
    static int countSquares(int n) {
        // code here
        int cnt = 0;
        for(int j=1; j*j<n; j++) {
            cnt++;
        }
        return cnt;
    }
}

//TC :O(root n)
//SC :O(1)


//static int countSquares(int n) {
//    return (int) Math.ceil(Math.sqrt(n)) - 1;
//}

//TC : O(1)
//SC: O(1)

//Math.sqrt(n) is a single library function call.
//It does not iterate from 1 to √n.
//Modern CPUs have hardware instructions or highly optimized algorithms (such as Newton-Raphson) that compute the square root in a fixed number of steps for primitive numeric types.