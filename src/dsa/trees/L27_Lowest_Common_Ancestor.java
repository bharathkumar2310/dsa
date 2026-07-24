package dsa.trees;

public class L27_Lowest_Common_Ancestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return rec(root, p, q);
    }

    TreeNode rec(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = rec(root.left, p, q);
        TreeNode right = rec(root.right, p, q);

        if(left!= null && right != null) {
            return root;
        }

        if(left != null) {
            return left;
        }

        return right;


    }
}

//TC : O(n)
//SC : O(h)