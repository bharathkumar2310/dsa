package dsa.trees;

public class L15_Check_For_Balance_Binary_Tree {
    public boolean isBalanced(Node root) {
        // code here
        return rec(root) == -1 ? false : true;
    }

    int rec(Node root) {
        if(root == null ) {
            return 0;
        }

        int left =  rec(root.left);
        if(left == -1) {
            return -1;
        }
        int right = rec(root.right);
        if(right == -1) {
            return -1;
        }

        if(Math.abs(left -right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);


    }
}


//TC : O(n)
//SC : O(h)