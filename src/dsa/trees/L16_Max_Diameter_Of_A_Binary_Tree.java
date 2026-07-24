package dsa.trees;

// instead of ans you can cretae array and pass it in recurrance
public class L16_Max_Diameter_Of_A_Binary_Tree {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        rec(root);
        return ans;
    }

    int rec(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = rec(root.left);
        int right = rec(root.right);

        ans = Math.max(left + right, ans);

        return 1 +  Math.max(left, right);

    }
}

//TC : O(n)
//SC : O(h)