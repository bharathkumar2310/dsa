package dsa.GFG;

public class L20_Pair_Cube_Count {
    public static int pairCubeCount(int n) {
        // code here
        long start = 0;
        long end = (long) Math.cbrt(n);
        int ans  = 0;
        while(start <= end) {
            long cube = (start * start * start) + (end * end * end);
            if(cube == n) {
                if(start == 0 || start == end) {
                    ans++;
                } else {
                    ans += 2;
                }
                start++;
                end--;
            }

            else if(cube > n) {
                end--;
            } else {
                start++;
            }
        }

        return ans;
    }
}

//TC : O(cube root n)
//SC : O(1)