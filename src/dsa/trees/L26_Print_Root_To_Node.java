package dsa.trees;

import java.util.ArrayList;
import java.util.List;

public class L26_Print_Root_To_Node {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        rec(root, ans, "");
        return ans;
    }

    void rec(TreeNode root, List<String> ans, String s) {
        if(root == null) {
            return;
        }

        if(s.isEmpty()) {
            s = String.valueOf(root.val);
        }
        else {
            s = s + "->" + String.valueOf(root.val);
        }

        if(root.left == null && root.right == null) {
            ans.add(s);
            return;
        }


        rec(root.left, ans, s);
        rec(root.right, ans, s);

    }
}

//TC : O(n)
//SC : O(n)