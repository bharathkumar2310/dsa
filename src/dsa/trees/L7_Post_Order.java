package dsa.trees;

import java.util.ArrayList;
import java.util.List;

public class L7_Post_Order {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(root, ans);
        return ans;
    }

    void postOrder(TreeNode root, List<Integer> ans) {
        if(root == null) {
            return;
        }

        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.val);

    }
}

//TC : O(n)
//SC : O(n)