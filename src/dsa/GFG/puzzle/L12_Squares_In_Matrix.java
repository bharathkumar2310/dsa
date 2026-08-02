package dsa.GFG.puzzle;

public class L12_Squares_In_Matrix {
    public int squaresInMatrix(int m, int n) {
        // code here

        int a = Math.min(m,n);
        int b = Math.max(m,n);

        int ans  = a*(a+1)*(3*b - a + 1)/6;
        return ans;

    }
}

//TC : O(1)
//SC : O(1)

// for i nterviews u can use the below ans


//Final Formula
//
//Therefore,
//
//Answer=
//
//a(a+1)(3b−a+1)/6  //This is the formula derived from the O(Min(m,n) soln)
//
//
//where
//a = min(m,n)
//b = max(m,n)



//public int squaresInMatrix(int m, int n) {
//    // code here
//
//    int ans = 0;
//
//    for(int i=1; i<=Math.min(m,n); i++) {
//        ans += (m-i+1) * (n-i+1);
//    }
//    return ans;
//
//}

//TC : O(min(m,n))
//SC : O(1)


//Suppose the matrix is:
//
//m = 3
//n = 5
//
//So the matrix is
//
//□ □ □ □ □
//□ □ □ □ □
//□ □ □ □ □
//
//We want to count all possible squares.
//
//1 × 1 squares
//
//Every cell itself is a square.
//
//        □ □ □ □ □
//        □ □ □ □ □
//        □ □ □ □ □
//
//There are
//
//3 × 5 = 15
//
//So
//
//        (m - 1 + 1) × (n - 1 + 1)
//
//        = m × n
//
//= 15
//        2 × 2 squares
//
//A 2×2 square needs
//
//2 rows
//2 columns
//
//Imagine sliding a 2×2 window.
//
//        Horizontal positions
//
//There are 5 columns.
//
//        A 2×2 square can start at
//
//Column 1
//Column 2
//Column 3
//Column 4
//
//Not column 5 because we'd go outside the matrix.
//
//So horizontal choices are
//
//5 - 2 + 1 = 4
//Vertical positions
//
//There are 3 rows.
//
//        A 2×2 square can start at
//
//Row 1
//Row 2
//
//Not row 3.
//
//So vertical choices are
//
//3 - 2 + 1 = 2
//
//Total
//
//2 × 4 = 8
//
//or
//
//        (m - 2 + 1) × (n - 2 + 1)
//
//        = (3-2+1)(5-2+1)
//
//        = 2 × 4 = 8
//        3 × 3 squares
//
//        Horizontal
//
//5-3+1 = 3
//
//Vertical
//
//3-3+1 = 1
//
//Total
//
//1 × 3 = 3
//        4 × 4 ?
//
//Impossible.
//
//        Because
//
//        Rows = 3
//
//A 4×4 square doesn't fit.
//
//So we stop at
//
//min(m,n)


//public int squaresInMatrix(int m, int n) {
//    // code here
//    int[][] dp = new int[m][n];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, 1);
//    }
//
//    int ans = 0 ;
//
//    for(int i=1; i<m; i++) {
//        for(int j=1; j<n; j++) {
//            dp[i][j] =1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
//        }
//    }
//
//    for(int i=0; i<m; i++) {
//        for(int j=0; j<n; j++) {
//            ans += dp[i][j];
//        }
//    }
//
//    return ans;
//}

//TC : O(n^2)
//SC : O(n^2)