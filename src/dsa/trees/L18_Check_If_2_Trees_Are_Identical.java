package dsa.trees;

public class L18_Check_If_2_Trees_Are_Identical {
    public boolean isIdentical(Node r1, Node r2) {
        // code here
        return rec(r1, r2);
    }

    boolean rec(Node r1, Node r2) {
        if(r1 == null && r2 == null) {
            return true;
        }
        if(r1 ==null || r2 ==null) {
            return false;
        }

        if(r1.data != r2.data) {
            return false;
        }

        boolean left = rec(r1.left, r2.left);
        boolean right = rec(r1.right, r2.right);

        return left & right;
    }
}


//TC : O(n)
//SC : O(h)