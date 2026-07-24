package dsa.trees;

import java.util.ArrayList;
import java.util.List;

public class L6_Inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }

    void inOrder(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return;
        }

        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }
}
//TC : O(n)
//SC : O(n)