package dsa.trees;


//Postorder: Every node asks its left and right subtree for (size, min, max).
//If left.max < root < right.min, combine both subtrees into a larger BST and update size, min, and max.
// Else, return the largest BST size from the children and poison (min = -∞, max = +∞) so no ancestor can include this invalid subtree.

public class L53_Largest_BST_In_TRee {
    static class TreeNode {
        int size;
        int min;
        int max;

        TreeNode(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int largestBst(Node root) {
        return rec(root).size;
    }

    static TreeNode rec(Node root) {

        if (root == null) {
            return new TreeNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        TreeNode left = rec(root.left);
        TreeNode right = rec(root.right);

        if (root.data > left.max && root.data < right.min) {

            return new TreeNode(
                    1 + left.size + right.size,
                    Math.min(root.data, left.min),
                    Math.max(root.data, right.max)
            );
        }

        return new TreeNode(
                Math.max(left.size, right.size),
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
        );
    }
}

//TC : O(n)
//SC : O(n)


