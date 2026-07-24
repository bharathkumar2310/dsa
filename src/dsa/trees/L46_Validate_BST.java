package dsa.trees;

public class L46_Validate_BST {
    public boolean isBST(Node root) {
        // code here
        return rec(-(int)1e9, (int)1e9, root);
    }

    boolean rec(int min, int max , Node root) {
        if(root == null) {
            return true;
        }

        if(root.data <= min || root.data >= max) {
            return false;
        }

        boolean left = rec(min, root.data, root.left);
        boolean right = rec(root.data, max, root.right);
        return left && right;
    }
}


//TC : O(n)
//SC : O(n)