package dsa.trees;

public class L25_Symmetric_Binary_Tree {
    public boolean isSymmetric(Node root) {
        // code here
        return rec(root.left, root.right);
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

        boolean left = rec(r1.left, r2.right);
        boolean right = rec(r1.right, r2.left);

        return left & right;
    }
}
