package dsa.trees;

public class L14_Max_Depth_Of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        return rec(root);
    }

    int rec(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = 1+rec(root.left);
        int right = 1+rec(root.right);

        return Math.max(left, right);
    }
}


//TC : O(n)
//SC : O(h)