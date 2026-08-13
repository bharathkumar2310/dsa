package dsa.GFG.puzzle;

public class L4_Check_For_Power {
    public boolean isPower(int x, int y) {
        // code here

        if(x == 1 && y!=1) {
            return false;
        }
        if(y ==1) {
            return true;
        }
        long ans = 1;
        while(ans <= y) {
            ans *=x;
            if(ans == y) {
                return true;
            }
        }

        return false;
    }
}


//TC : O(logn)
//SC : O(1)